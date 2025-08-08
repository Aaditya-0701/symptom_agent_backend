package com.example.symptom_classifier.repository;

import com.example.symptom_classifier.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    // Optional: add methods like findByName or findByContactInfo
}
