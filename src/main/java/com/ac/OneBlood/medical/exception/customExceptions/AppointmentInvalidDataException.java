package com.ac.OneBlood.medical.exception.customExceptions;

public class AppointmentInvalidDataException extends RuntimeException {
    private static final String APPOINTMENT_INVALID_MESSAGE = "Appointment with %s id is invalid";
    public AppointmentInvalidDataException(Long id) {
        super(String.format(APPOINTMENT_INVALID_MESSAGE, id));
    }
}
