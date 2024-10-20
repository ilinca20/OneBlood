package com.ac.OneBlood.medical.repository;

import com.ac.OneBlood.account.model.Role;
import com.ac.OneBlood.account.model.User;
import com.ac.OneBlood.account.repository.UserRepository;
import com.ac.OneBlood.medical.entity.Appointment;
import com.ac.OneBlood.medical.entity.Doctor;
import com.ac.OneBlood.medical.entity.Patient;
import com.ac.OneBlood.medical.entity.PatientStatus;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostConstruct
    public void init() {
        userRepository.save(new User(1, "alice.brown@example.com", "123456", Role.ROLE_PATIENT));
        userRepository.save(new User(2, "john.doe@one.com", "123456", Role.ROLE_DOCTOR));
        userRepository.save(new User(3, "ilinca@one.com", "123456", Role.ROLE_ADMIN));

        doctorRepository.save(Doctor.builder()
                .specialty("Cardiology")
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("555-1234")
                .email("john.doe@one.com")
                .build());

        patientRepository.save(Patient.builder()
                .firstName("Alice")
                .lastName("Brown")
                .email("alice.brown@example.com")
                .gender("Female")
                .status(PatientStatus.ELIGIBLE)
                .phoneNumber("555-1122")
                .dateOfBirth(LocalDate.of(1990,6,9))
                .build());

        appointmentRepository.save(Appointment.builder()
                .city("Iasi")
                .status("Completed")
                .county("Iasi")
                .doctor(Doctor.builder()
                        .specialty("Cardiology")
                        .firstName("John")
                        .lastName("Doe")
                        .phoneNumber("555-1234")
                        .email("john.doe@one.com")
                        .build())
                .patient(Patient.builder()
                        .firstName("Alice")
                        .lastName("Brown")
                        .email("alice.brown@example.com")
                        .gender("Female")
                        .status(PatientStatus.ELIGIBLE)
                        .phoneNumber("555-1122")
                        .dateOfBirth(LocalDate.of(1990,6,9))
                        .build())
                .notes("notes")
                .appointmentDateAndHour(LocalDateTime.of(2024, 10, 15, 10,10))
                .build());
    }
}

