package com.example.symptom_classifier.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    private String appointmentId;

    private String patientName;

    private String doctorId;

    private String doctorName;

    private Instant appointmentDateTime;

    private String symptomsCategory;

    private String contactInfo;

    private String status;

    private Instant bookingTimestamp;

    // Constructors

    public Appointment() {
    }

    public Appointment(String appointmentId, String patientName, String doctorId, String doctorName,
                       Instant appointmentDateTime, String symptomsCategory, String contactInfo,
                       String status, Instant bookingTimestamp) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.appointmentDateTime = appointmentDateTime;
        this.symptomsCategory = symptomsCategory;
        this.contactInfo = contactInfo;
        this.status = status;
        this.bookingTimestamp = bookingTimestamp;
    }

    // Getters and Setters

    public String getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    public String getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public Instant getAppointmentDateTime() {
        return appointmentDateTime;
    }
    public void setAppointmentDateTime(Instant appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }
    public String getSymptomsCategory() {
        return symptomsCategory;
    }
    public void setSymptomsCategory(String symptomsCategory) {
        this.symptomsCategory = symptomsCategory;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Instant getBookingTimestamp() {
        return bookingTimestamp;
    }
    public void setBookingTimestamp(Instant bookingTimestamp) {
        this.bookingTimestamp = bookingTimestamp;
    }
}
