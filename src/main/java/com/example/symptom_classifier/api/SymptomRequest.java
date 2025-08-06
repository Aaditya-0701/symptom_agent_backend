package com.example.symptom_classifier.api;


public record SymptomRequest(
        String patientName,
        String symptomsDescription,
        Integer patientAge,
        String patientGender
) {}
