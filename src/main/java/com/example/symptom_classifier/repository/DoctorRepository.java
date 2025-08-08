package com.example.symptom_classifier.repository;

import com.example.symptom_classifier.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {
    // Add custom query methods here if needed (e.g. by specialty, location)
}
