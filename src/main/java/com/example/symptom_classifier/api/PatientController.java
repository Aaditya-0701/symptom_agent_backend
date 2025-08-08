package com.example.symptom_classifier.api;

import com.example.symptom_classifier.model.Patient;
import com.example.symptom_classifier.service.PatientService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService service;
    public PatientController(PatientService service) { this.service = service; }

    @GetMapping
    public List<Patient> getAllPatients() { return service.getAllPatients(); }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable String id) {
        return service.getPatientById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) { return service.savePatient(patient); }
}
