package com.example.symptom_classifier.api;

import com.example.symptom_classifier.service.ClassificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classify-symptoms")
public class ClassificationController {
    private final ClassificationService service;

    public ClassificationController(ClassificationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SymptomResponse> classify(@RequestBody SymptomRequest request) {
        SymptomResponse response = service.classify(request);
        return ResponseEntity.ok(response);
    }
}
