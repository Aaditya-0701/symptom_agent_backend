package com.example.symptom_classifier.api;

import com.example.symptom_classifier.service.LoggingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
public class LoggingController {

    private final LoggingService loggingService;

    public LoggingController(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @PostMapping
    public ResponseEntity<?> logInteraction(@RequestBody LogEntryRequest logRequest) {
        String logId = loggingService.logInteraction(logRequest);
        return ResponseEntity.ok("Log entry recorded with ID: " + logId);
    }
}
