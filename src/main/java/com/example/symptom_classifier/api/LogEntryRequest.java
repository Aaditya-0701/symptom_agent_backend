package com.example.symptom_classifier.api;

import java.util.Map;

public record LogEntryRequest(
        String patientName,
        String interactionType,
        Map<String, Object> interactionData,
        String sessionId,
        String severityLevel
) {}
