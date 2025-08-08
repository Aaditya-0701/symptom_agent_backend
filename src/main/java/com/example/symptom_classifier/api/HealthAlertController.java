package com.example.symptom_classifier.api;

import com.example.symptom_classifier.model.HealthAlert;
import com.example.symptom_classifier.service.HealthAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health-awareness")
public class HealthAlertController {

    private final HealthAlertService service;

    public HealthAlertController(HealthAlertService service) { this.service = service; }

    @GetMapping
    public List<HealthAlert> getAllAlerts() { return service.getAllAlerts(); }

    @GetMapping("/{id}")
    public HealthAlert getAlertById(@PathVariable String id) {
        return service.getAlertById(id).orElseThrow(() -> new RuntimeException("Alert not found"));
    }

    @PostMapping
    public HealthAlert saveAlert(@RequestBody HealthAlert alert) {
        return service.saveAlert(alert);
    }

    // Optional: add @GetMapping with query params (location, condition) for agent-side searches
}
