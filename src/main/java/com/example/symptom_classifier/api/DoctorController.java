package com.example.symptom_classifier.api;

import com.example.symptom_classifier.api.DoctorInfo;
import com.example.symptom_classifier.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping
    public List<DoctorInfo> getAllDoctors() { return service.getAllDoctors(); }

    @GetMapping("/{id}")
    public DoctorInfo getDoctorById(@PathVariable String id) {
        return service.getDoctorById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    @PostMapping
    public DoctorInfo saveDoctor(@RequestBody DoctorInfo doctorInfo) {
        return service.saveDoctor(doctorInfo);
    }
}
