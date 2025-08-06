package com.example.symptom_classifier.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "patient_logs")
public class PatientLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;

    private String sessionId;

    private String interactionType;

    @Column(columnDefinition = "TEXT")
    private String interactionData;

    private String severityLevel;

    private Instant timestamp;

    // Constructors

    public PatientLog() {
    }

    public PatientLog(String patientName, String sessionId, String interactionType, String interactionData,
                      String severityLevel, Instant timestamp) {
        this.patientName = patientName;
        this.sessionId = sessionId;
        this.interactionType = interactionType;
        this.interactionData = interactionData;
        this.severityLevel = severityLevel;
        this.timestamp = timestamp;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public String getInteractionType() {
        return interactionType;
    }
    public void setInteractionType(String interactionType) {
        this.interactionType = interactionType;
    }
    public String getInteractionData() {
        return interactionData;
    }
    public void setInteractionData(String interactionData) {
        this.interactionData = interactionData;
    }
    public String getSeverityLevel() {
        return severityLevel;
    }
    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }
    public Instant getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
