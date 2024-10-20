package com.ac.OneBlood.medical.builder;

import com.ac.OneBlood.medical.dto.AppointmentDto;
import com.ac.OneBlood.medical.dto.DoctorDto;
import com.ac.OneBlood.medical.dto.PatientDto;
import com.ac.OneBlood.medical.entity.Appointment;
import com.ac.OneBlood.medical.entity.Doctor;
import com.ac.OneBlood.medical.entity.Patient;
import org.springframework.stereotype.Component;

@Component
public class Builder {
    public PatientDto buildPatientDto(Patient patient) {
        return PatientDto.builder()
                .patientId(patient.getPatientId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .phoneNumber(patient.getPhoneNumber())
                .email(patient.getEmail())
                .status(patient.getStatus())
                .gender(patient.getGender())
                .dateOfBirth(patient.getDateOfBirth())
                .build();
    }
    public Patient buildPatient(PatientDto patientDto) {
        return Patient.builder()
                .patientId(patientDto.getPatientId())
                .firstName(patientDto.getFirstName())
                .lastName(patientDto.getLastName())
                .gender(patientDto.getGender())
                .email(patientDto.getEmail())
                .status(patientDto.getStatus())
                .dateOfBirth(patientDto.getDateOfBirth())
                .phoneNumber(patientDto.getPhoneNumber()).build();
    }

    public DoctorDto buildDoctorDto(Doctor doctor) {
        return DoctorDto.builder()
                .doctorId(doctor.getDoctorId())
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .email(doctor.getEmail())
                .specialty(doctor.getSpecialty())
                .phoneNumber(doctor.getPhoneNumber())
                .build();
    }

    public Doctor buildDoctor(DoctorDto doctorDto) {
        return Doctor.builder()
                .doctorId(doctorDto.getDoctorId())
                .firstName(doctorDto.getFirstName())
                .lastName(doctorDto.getLastName())
                .email(doctorDto.getEmail())
                .specialty(doctorDto.getSpecialty())
                .phoneNumber(doctorDto.getPhoneNumber())
                .build();
    }

    public Appointment buildAppointment(AppointmentDto appointmentDto, Patient patient, Doctor doctor) {
        return Appointment.builder()
                .appointmentId(appointmentDto.getAppointmentId())
                .appointmentDateAndHour(appointmentDto.getAppointmentDateAndHour())
                .county(appointmentDto.getCounty())
                .city(appointmentDto.getCity())
                .status(appointmentDto.getStatus())
                .patient(patient)
                .doctor(doctor)
                .notes(appointmentDto.getNotes())
                .build();
    }

    public AppointmentDto buildAppointmentDto(Appointment appointment) {
        return AppointmentDto.builder()
                .appointmentId(appointment.getAppointmentId())
                .appointmentDateAndHour(appointment.getAppointmentDateAndHour())
                .city(appointment.getCity())
                .county(appointment.getCounty())
                .status(appointment.getStatus())
                .patient(buildPatientDto(appointment.getPatient()))
                .doctor(buildDoctorDto(appointment.getDoctor()))
                .notes(appointment.getNotes())
                .build();
    }

}
