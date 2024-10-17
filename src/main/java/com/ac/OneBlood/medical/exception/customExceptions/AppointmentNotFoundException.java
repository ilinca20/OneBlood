package com.ac.OneBlood.medical.exception.customExceptions;

public class AppointmentNotFoundException extends RuntimeException {
    private static final String APPOINTMENT_NOT_FOUND_MESSAGE = "Appointment with id %s not found in the db";
    public AppointmentNotFoundException(Long id) {
        super(String.format(APPOINTMENT_NOT_FOUND_MESSAGE, id));
    }
}
