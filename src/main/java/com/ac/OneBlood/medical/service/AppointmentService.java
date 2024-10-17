package com.ac.OneBlood.medical.service;

import com.ac.OneBlood.medical.builder.Builder;
import com.ac.OneBlood.medical.dto.AppointmentDto;
import com.ac.OneBlood.medical.entity.Appointment;

import com.ac.OneBlood.medical.exception.customExceptions.AppointmentInvalidDataException;
import com.ac.OneBlood.medical.exception.customExceptions.AppointmentNotFoundException;
import com.ac.OneBlood.medical.exception.customExceptions.DoctorNotFoundException;
import com.ac.OneBlood.medical.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private Builder builder;

    public Appointment addNewAppointment(AppointmentDto appointmentDTO) throws Exception {
        LocalDateTime appointmentDate;

        doctorService.getDoctorById(appointmentDTO.getDoctor().getDoctorId());

        patientService.getPatientById(appointmentDTO.getPatient().getPatientId());

        try {
            appointmentDate = appointmentDTO.getAppointmentDateAndHour();
        } catch (Exception e) {
            throw new AppointmentInvalidDataException(appointmentDTO.getAppointmentId());
        }

        List<Appointment> conflictingAppointments = appointmentRepository.findByDoctorAndAppointmentDate(appointmentDTO.getDoctor().getDoctorId(), appointmentDate);
        if (!conflictingAppointments.isEmpty()) {
            throw new Exception("The doctor already has an appointment at this date and time.");
        }

        Appointment newAppointment = builder.buildAppointment(appointmentDTO, patientService.getPatientById(appointmentDTO.getPatient().getPatientId()), doctorService.getDoctorById(appointmentDTO.getDoctor().getDoctorId()));
        return appointmentRepository.save(newAppointment);
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new AppointmentNotFoundException(id));
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

}
