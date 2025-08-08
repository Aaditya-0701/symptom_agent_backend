package com.example.symptom_classifier.service;

import com.example.symptom_classifier.model.HealthAlert;
import com.example.symptom_classifier.repository.HealthAlertRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HealthAlertService {
    private final HealthAlertRepository repository;

    public HealthAlertService(HealthAlertRepository repository) { this.repository = repository; }

    public HealthAlert saveAlert(HealthAlert alert) { return repository.save(alert); }

    public List<HealthAlert> getAllAlerts() { return repository.findAll(); }

    public Optional<HealthAlert> getAlertById(String id) { return repository.findById(id); }

    // Custom: find by location and/or condition(s) for agent queries
    // Implement as needed
}
