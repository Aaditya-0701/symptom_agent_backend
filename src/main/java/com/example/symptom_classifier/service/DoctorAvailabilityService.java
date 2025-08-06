package com.example.symptom_classifier.service;

import com.example.symptom_classifier.api.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorAvailabilityService {

    private static final List<DoctorInfo> MOCK_DOCTORS = List.of(
            new DoctorInfo("DR001", "Dr. Sarah Johnson", "general_medicine", "Main Hospital", 4.8, 12,
                    List.of("09:00", "10:30", "14:00", "15:30")),
            new DoctorInfo("DR002", "Dr. Michael Chen", "general_medicine", "Downtown Clinic", 4.9, 8,
                    List.of("09:30", "11:00", "13:30", "16:00")),
            new DoctorInfo("DR003", "Dr. Emily Rodriguez", "psychiatry", "Mental Health Center", 4.7, 15,
                    List.of("10:00", "11:30", "14:30", "17:00")),
            new DoctorInfo("DR004", "Dr. James Wilson", "cardiology", "Cardiac Care Unit", 4.9, 20,
                    List.of("09:00", "10:00", "13:00", "15:00"))
    );

    public DoctorAvailabilityResponse checkAvailability(DoctorAvailabilityRequest request) {
        try {
            String preferredTime = request.preferredTimeSlot().toLowerCase();

            // Normalize time slots for generic labels (morning, afternoon, evening)
            List<String> timeSlots;
            switch (preferredTime) {
                case "morning" -> timeSlots = List.of("09:00", "09:30", "10:00", "10:30", "11:00", "11:30");
                case "afternoon" -> timeSlots = List.of("13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30");
                case "evening" -> timeSlots = List.of("17:00", "17:30", "18:00", "18:30", "19:00", "19:30");
                default -> timeSlots = List.of(request.preferredTimeSlot());
            }

            List<DoctorInfo> availableDoctors = new ArrayList<>();

            for (DoctorInfo doc : MOCK_DOCTORS) {
                boolean specialtyMatches = request.specialtyRequired().equalsIgnoreCase("any")
                        || doc.specialty().equalsIgnoreCase(request.specialtyRequired());
                boolean locationMatches = request.locationPreference().equalsIgnoreCase("any")
                        || doc.location().equalsIgnoreCase(request.locationPreference());

                if (specialtyMatches && locationMatches) {
                    List<String> commonSlots = doc.availableSlots().stream()
                            .filter(timeSlots::contains)
                            .toList();
                    if (!commonSlots.isEmpty()) {
                        availableDoctors.add(new DoctorInfo(
                                doc.id(),
                                doc.name(),
                                doc.specialty(),
                                doc.location(),
                                doc.rating(),
                                doc.experienceYears(),
                                commonSlots
                        ));
                    }
                }
            }

            // Sort doctors by rating and experience descending
            availableDoctors = availableDoctors.stream()
                    .sorted((d1, d2) -> {
                        int ratingCmp = Double.compare(d2.rating(), d1.rating());
                        if (ratingCmp != 0) return ratingCmp;
                        return Integer.compare(d2.experienceYears(), d1.experienceYears());
                    }).limit(5).toList();

            return new DoctorAvailabilityResponse(
                    true,
                    request.preferredTimeSlot(),
                    request.specialtyRequired(),
                    availableDoctors,
                    availableDoctors.size(),
                    Instant.now().toString(),
                    null
            );
        } catch (Exception e) {
            return new DoctorAvailabilityResponse(
                    false,
                    request.preferredTimeSlot(),
                    request.specialtyRequired(),
                    List.of(),
                    0,
                    Instant.now().toString(),
                    "Error during doctor availability check: " + e.getMessage()
            );
        }
    }
}
