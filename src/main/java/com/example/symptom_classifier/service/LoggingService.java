package com.example.symptom_classifier.service;

import com.example.symptom_classifier.api.LogEntryRequest;
import com.example.symptom_classifier.model.PatientLog;
import com.example.symptom_classifier.repository.PatientLogRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LoggingService {
    private final PatientLogRepository logRepo;

    public LoggingService(PatientLogRepository logRepo) {
        this.logRepo = logRepo;
    }

    public String logInteraction(LogEntryRequest req) {
        PatientLog log = new PatientLog();
        log.setPatientName(req.patientName());
        log.setSessionId(req.sessionId());
        log.setInteractionType(req.interactionType());
        log.setInteractionData(req.interactionData().toString());
        log.setSeverityLevel(req.severityLevel());
        log.setTimestamp(Instant.now());
        log = logRepo.save(log);
        return log.getId().toString();
    }
}
