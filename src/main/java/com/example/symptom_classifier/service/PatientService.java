package com.example.symptom_classifier.service;

import com.example.symptom_classifier.model.Patient;
import com.example.symptom_classifier.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository repository;
    public PatientService(PatientRepository repository) { this.repository = repository; }

    public Patient savePatient(Patient patient) { return repository.save(patient); }
    public List<Patient> getAllPatients() { return repository.findAll(); }
    public Optional<Patient> getPatientById(String id) { return repository.findById(id); }
}
