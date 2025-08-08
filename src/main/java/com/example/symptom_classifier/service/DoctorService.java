package com.example.symptom_classifier.service;

import com.example.symptom_classifier.model.Doctor;       // JPA Entity
import com.example.symptom_classifier.api.DoctorInfo;     // DTO/record
import com.example.symptom_classifier.repository.DoctorRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    // Save a doctor (mapping DTO to Entity)
    public DoctorInfo saveDoctor(DoctorInfo info) {
        Doctor entity = new Doctor(
                info.id(),
                info.name(),
                info.specialty(),
                info.location(),
                info.rating(),
                info.experienceYears(),
                info.availableSlots()
        );
        Doctor saved = repository.save(entity);
        return new DoctorInfo(
                saved.getId(),
                saved.getName(),
                saved.getSpecialty(),
                saved.getLocation(),
                saved.getRating(),
                saved.getExperienceYears(),
                saved.getAvailableSlots()
        );
    }

    // Get all doctors
    public List<DoctorInfo> getAllDoctors() {
        return repository.findAll().stream()
                .map(doc -> new DoctorInfo(
                        doc.getId(),
                        doc.getName(),
                        doc.getSpecialty(),
                        doc.getLocation(),
                        doc.getRating(),
                        doc.getExperienceYears(),
                        doc.getAvailableSlots()
                ))
                .collect(Collectors.toList());
    }

    // Get doctor by ID
    public Optional<DoctorInfo> getDoctorById(String id) {
        return repository.findById(id)
                .map(doc -> new DoctorInfo(
                        doc.getId(),
                        doc.getName(),
                        doc.getSpecialty(),
                        doc.getLocation(),
                        doc.getRating(),
                        doc.getExperienceYears(),
                        doc.getAvailableSlots()
                ));
    }
}
