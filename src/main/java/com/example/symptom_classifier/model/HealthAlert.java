package com.example.symptom_classifier.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "health_alerts")
public class HealthAlert {
    @Id
    private String alertId;
    private String location;
    @ElementCollection
    private List<String> conditions;
    private String message;
    private LocalDate validUntil;
    // Constructors, getters, setters...


    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getConditions() {
        return conditions;
    }

    public void setConditions(List<String> conditions) {
        this.conditions = conditions;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public HealthAlert(String alertId, String location, List<String> conditions, String message, LocalDate validUntil) {
        this.alertId = alertId;
        this.location = location;
        this.conditions = conditions;
        this.message = message;
        this.validUntil = validUntil;
    }

    public HealthAlert() {
    }
}
