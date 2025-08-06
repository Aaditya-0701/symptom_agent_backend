package com.example.symptom_classifier.api;

import com.example.symptom_classifier.service.DoctorAvailabilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor-availability")
public class DoctorAvailabilityController {

    private final DoctorAvailabilityService service;

    public DoctorAvailabilityController(DoctorAvailabilityService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DoctorAvailabilityResponse> getAvailability(@RequestBody DoctorAvailabilityRequest request) {
        return ResponseEntity.ok(service.checkAvailability(request));
    }
}
