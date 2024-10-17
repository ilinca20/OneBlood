package com.ac.OneBlood.medical;

import com.ac.OneBlood.medical.builder.Builder;
import com.ac.OneBlood.medical.dto.AppointmentDto;
import com.ac.OneBlood.medical.dto.DoctorDto;
import com.ac.OneBlood.medical.dto.PatientDto;
import com.ac.OneBlood.medical.entity.Appointment;
import com.ac.OneBlood.medical.entity.Doctor;
import com.ac.OneBlood.medical.entity.Patient;
import com.ac.OneBlood.medical.service.AppointmentService;
import com.ac.OneBlood.medical.service.DoctorService;
import com.ac.OneBlood.medical.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedicalController {

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    Builder builder;
    //difference between with private and without private
    @GetMapping("/v1/medical/doctor/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        DoctorDto response = builder.buildDoctorDto(doctor);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/v1/medical/doctor")
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody Doctor doctor) {
        doctorService.createDoctor(doctor);
        DoctorDto response = builder.buildDoctorDto(doctor);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/v1/medical/patient/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        PatientDto response = builder.buildPatientDto(patient);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/v1/medical/patient")
    public ResponseEntity<PatientDto> createPatient(@RequestBody Patient patient) {
        patientService.createPatient(patient);
        PatientDto response = builder.buildPatientDto(patient);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/v1/medical/appointment/{id}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        AppointmentDto response = builder.buildAppointmentDto(appointment);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/v1/medical/appointment")
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody Appointment appointment) throws Exception {
        Appointment newAppointment = appointmentService.addNewAppointment(builder.buildAppointmentDto(appointment));
        AppointmentDto response = builder.buildAppointmentDto(newAppointment);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
