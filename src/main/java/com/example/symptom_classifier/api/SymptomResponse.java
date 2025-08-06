package com.example.symptom_classifier.api;

public record SymptomResponse(
        String patientName,
        String category,
        double confidence,
        String reasoning,
        String urgencyLevel,
        String classificationId,
        String timestamp
) {}
