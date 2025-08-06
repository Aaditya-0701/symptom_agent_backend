package com.example.symptom_classifier.repository;

import com.example.symptom_classifier.model.PatientLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientLogRepository extends JpaRepository<PatientLog, Long> {
}
