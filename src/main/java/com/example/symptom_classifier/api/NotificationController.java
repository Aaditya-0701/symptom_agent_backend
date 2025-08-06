package com.example.symptom_classifier.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @PostMapping
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
        // In a real app, forward to notification service (email/SMS/etc)
        System.out.println("Notification sent to " + request.patientName() + ": " + request.message());
        return ResponseEntity.ok("Notification sent");
    }
}

