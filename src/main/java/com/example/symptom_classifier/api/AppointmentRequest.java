package com.example.symptom_classifier.api;


public record AppointmentRequest(
        String patientName,
        String doctorId,
        String doctorName,
        String appointmentTime,   // e.g. "15:30"
        String appointmentDate,   // e.g. "2025-08-06"
        String symptomsCategory,  // e.g. "general"
        String contactInfo        // optional, can be null
) {}
