package com.ac.OneBlood.medical.service;

import com.ac.OneBlood.medical.entity.Patient;
import com.ac.OneBlood.medical.repository.PatientRepository;
import com.ac.OneBlood.medical.service.validator.EntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private EntityValidator validator;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient createPatient(Patient patient) throws Exception {
        //validations
        validator.validatePatientAge(patient);
        return patientRepository.save(patient);
    }
}
