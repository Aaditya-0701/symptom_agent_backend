package com.example.symptom_classifier.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    private String id;

    private String name;
    private String specialty;
    private String location;
    private double rating;
    private int experienceYears;

    public Doctor() {
    }

    @ElementCollection
    private List<String> availableSlots;

    public Doctor(String id, String name, String specialty, String location, double rating, int experienceYears, List<String> availableSlots) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.location = location;
        this.rating = rating;
        this.experienceYears = experienceYears;
        this.availableSlots = availableSlots;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        this.availableSlots = availableSlots;
    }
}
