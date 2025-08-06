package com.example.symptom_classifier.service;

import com.example.symptom_classifier.api.SymptomRequest;
import com.example.symptom_classifier.api.SymptomResponse;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class ClassificationService {
    private static final List<String> EMERGENCY_KEYWORDS = List.of(
            "chest pain","difficulty breathing","shortness of breath","stroke","heart attack",
            "severe bleeding","severe allergic reaction","unconscious","severe burns","choking","seizure"
    );

    private static final List<String> MENTAL_KEYWORDS = List.of(
            "depression","anxiety","panic","stress","sad","hopeless","insomnia","grief","suicidal"
    );

    public SymptomResponse classify(SymptomRequest req) {
        String desc = req.symptomsDescription().toLowerCase();
        String category;
        double confidence;
        String reasoning;
        String urgency;

        boolean emergency = EMERGENCY_KEYWORDS.stream().anyMatch(desc::contains);
        boolean mental = MENTAL_KEYWORDS.stream().anyMatch(desc::contains);

        if (emergency) {
            category = "emergency";
            confidence = 0.9;
            reasoning = "Emergency keyword matched";
            urgency = "IMMEDIATE";
        } else if (mental) {
            category = "mental";
            confidence = 0.8;
            reasoning = "Mental-health keyword matched";
            urgency = "MODERATE";
        } else {
            category = "general";
            confidence = 0.7;
            reasoning = "Defaulted to general";
            urgency = "LOW_TO_MODERATE";
        }

        return new SymptomResponse(
                req.patientName(),
                category,
                confidence,
                reasoning,
                urgency,
                UUID.randomUUID().toString(),
                Instant.now().toString()
        );
    }
}
