package com.example.symptom_classifier.api;

public record DoctorAvailabilityRequest(
        String preferredTimeSlot,  // e.g. "morning", "15:00"
        String specialtyRequired,  // e.g. "general_medicine", "psychiatry"
        String locationPreference  // e.g. "Main Hospital" or "any"
) {}
