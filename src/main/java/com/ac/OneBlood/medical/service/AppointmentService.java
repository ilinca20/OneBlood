package com.ac.OneBlood.medical.service;

import com.ac.OneBlood.medical.entity.Appointment;
import com.ac.OneBlood.medical.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    //explore constructor injection

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public void createAppointment(Appointment appointment) {
        //validations
        appointmentRepository.save(appointment);
    }

    //make a new client call to get data from https://roloca.coldfuse.io/ro for counties and cities
}
