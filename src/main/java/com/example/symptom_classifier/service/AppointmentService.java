package com.example.symptom_classifier.service;

import com.example.symptom_classifier.api.AppointmentRequest;
import com.example.symptom_classifier.api.AppointmentResponse;
import com.example.symptom_classifier.model.Appointment;
import com.example.symptom_classifier.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentResponse scheduleAppointment(AppointmentRequest req) {
        try {
            // Generate appointment ID
            String appointmentId = "APPT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

            // Parse appointment date and time strings into Instant (assuming local timezone)
            String dateTimeString = req.appointmentDate() + " " + req.appointmentTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
            Instant appointmentInstant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();

            // Create Appointment entity
            Appointment appointment = new Appointment(
                    appointmentId,
                    req.patientName(),
                    req.doctorId(),
                    req.doctorName(),
                    appointmentInstant,
                    req.symptomsCategory(),
                    req.contactInfo(),
                    "CONFIRMED",
                    Instant.now()
            );

            // Save to database
            appointmentRepository.save(appointment);

            String formattedDateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd 'at' HH:mm"));

            String confirmationMessage = String.format("""
                🎉 Appointment Successfully Booked! 🎉

                Dear %s,

                Your appointment has been confirmed with the following details:
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
                📅 Appointment ID: %s
                👩‍⚕️ Doctor: %s
                📆 Date & Time: %s
                🏥 Department: %s Medicine
                📋 Status: CONFIRMED
                ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

                📝 Please arrive 15 minutes early and bring your ID and insurance card.
                We look forward to seeing you! 💚
                """,
                    req.patientName(),
                    appointmentId,
                    req.doctorName(),
                    formattedDateTime,
                    capitalize(req.symptomsCategory())
            );

            return new AppointmentResponse(true, appointmentId, req.patientName(), req.doctorName(), formattedDateTime, confirmationMessage, null);
        } catch (Exception e) {
            return new AppointmentResponse(false, null, req.patientName(), req.doctorName(), null, null, "Failed to book appointment: " + e.getMessage());
        }
    }

    private String capitalize(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
