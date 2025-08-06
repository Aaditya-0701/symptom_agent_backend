package com.example.symptom_classifier.api;

import java.util.List;

public record DoctorAvailabilityResponse(
        boolean success,
        String requestedTimeSlot,
        String specialty,
        List<DoctorInfo> availableDoctors,
        int totalAvailable,
        String searchTimestamp,
        String errorMessage
) {}
