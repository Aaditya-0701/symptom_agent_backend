package com.example.symptom_classifier.repository;

import com.example.symptom_classifier.model.HealthAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthAlertRepository extends JpaRepository<HealthAlert, String> {
    // Optional: methods like findByLocation, findByConditionsContaining
}
