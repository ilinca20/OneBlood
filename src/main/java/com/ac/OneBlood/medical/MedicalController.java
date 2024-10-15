package com.ac.OneBlood.medical;

import com.ac.OneBlood.medical.entity.Doctor;
import com.ac.OneBlood.medical.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MedicalController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("v1/medical/doctor/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        doctorService.createDoctor(doctor);
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }
}
