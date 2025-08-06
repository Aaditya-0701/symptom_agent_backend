package com.example.symptom_classifier.api;

import java.util.List;

public record DoctorInfo(
        String id,
        String name,
        String specialty,
        String location,
        double rating,
        int experienceYears,
        List<String> availableSlots
) {}
