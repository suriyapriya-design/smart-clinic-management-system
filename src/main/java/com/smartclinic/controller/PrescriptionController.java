package com.smartclinic.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/prescriptions")
@CrossOrigin(origins = "*")
public class PrescriptionController {

    private final List<Map<String, Object>> prescriptions =
            new ArrayList<>();

    @GetMapping
    public List<Map<String, Object>> getPrescriptions() {
        return prescriptions;
    }

    @PostMapping
    public Map<String, Object> addPrescription(
            @RequestBody Map<String, Object> prescription) {
        prescription.put("id", prescriptions.size() + 1);
        prescriptions.add(prescription);
        return prescription;
    }
}
