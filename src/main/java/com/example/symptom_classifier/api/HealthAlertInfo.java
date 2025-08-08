package com.example.symptom_classifier.api;

import java.time.LocalDate;
import java.util.List;

public record HealthAlertInfo(
        String alertId,
        String location,
        List<String> conditions,
        String message,
        LocalDate validUntil
) {}
