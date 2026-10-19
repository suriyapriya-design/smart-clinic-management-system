```java
package com.smartclinic.controller;

import com.smartclinic.model.Doctor;
import com.smartclinic.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<?> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @PostMapping
    public ResponseEntity<?> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.addDoctor(doctor));
    }

    @GetMapping("/availability")
    public ResponseEntity<?> getDoctorAvailability(
            @RequestParam("user") String user,
            @RequestParam("doctorId") Long doctorId,
            @RequestParam("date") String date,
            @RequestParam("token") String token) {

        if (user == null || user.isBlank()
                || doctorId == null
                || date == null || date.isBlank()
                || token == null || token.isBlank()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Missing required parameters"));
        }

        if (!"ADMIN".equalsIgnoreCase(user)
                && !"DOCTOR".equalsIgnoreCase(user)
                && !"PATIENT".equalsIgnoreCase(user)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Map.of("error", "Invalid user role"));
        }

        // Replace this placeholder with your actual token validation.
        if (!isValidToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid token"));
        }

        Map<String, Object> response = new HashMap<>();
        response.put("doctorId", doctorId);
        response.put("date", date);
        response.put("available", true);

        return ResponseEntity.ok(response);
    }

    private boolean isValidToken(String token) {
        // Placeholder only: connect this to your real TokenService.
        return false;
    }
}
```
