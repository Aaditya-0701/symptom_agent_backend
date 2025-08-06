package com.example.symptom_classifier.api;

public record NotificationRequest(
        String patientName,
        String notificationType,
        String message,
        String priority
) {}
