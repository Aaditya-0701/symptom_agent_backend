package com.example.symptom_classifier.api;

import java.util.List;

public record PatientInfo(
        String id,
        String name,
        int age,
        String gender,
        String contactInfo,
        String location,
        List<String> medicalHistory
) {}
