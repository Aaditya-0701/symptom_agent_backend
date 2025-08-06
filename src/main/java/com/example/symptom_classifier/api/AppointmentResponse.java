package com.example.symptom_classifier.api;

public record AppointmentResponse(
        boolean success,
        String appointmentId,
        String patientName,
        String doctorName,
        String appointmentDateTime,
        String confirmationMessage,
        String errorMessage
) {}
