package com.ac.OneBlood.medical.service;

import com.ac.OneBlood.medical.entity.Doctor;
import com.ac.OneBlood.medical.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) { return doctorRepository.findById(id)};

    public void createDoctor(Doctor doctor) {
        //validations
        doctorRepository.save(doctor);
    }
}
