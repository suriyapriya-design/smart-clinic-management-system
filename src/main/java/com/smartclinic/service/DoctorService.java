```java
package com.smartclinic.service;

import com.smartclinic.model.Doctor;
import com.smartclinic.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId);
    }

    public Map<String, Object> getAvailableTimeSlots(
            Long doctorId, String date) {

        Map<String, Object> response = new HashMap<>();

        Optional<Doctor> doctor = doctorRepository.findById(doctorId);

        if (doctor.isEmpty()) {
            response.put("error", "Doctor not found");
            return response;
        }

        response.put("doctorId", doctorId);
        response.put("doctorName", doctor.get().getName());
        response.put("date", date);
        response.put("availableTime", doctor.get().getAvailableTime());

        return response;
    }

    public boolean validateDoctorLogin(String email, String password) {
        if (email == null || password == null) {
            return false;
        }

        Optional<Doctor> doctor =
                doctorRepository.findAll().stream()
                        .filter(d -> email.equalsIgnoreCase(d.getEmail()))
                        .findFirst();

        return doctor.isPresent()
                && password.equals(doctor.get().getPassword());
    }
}
```
