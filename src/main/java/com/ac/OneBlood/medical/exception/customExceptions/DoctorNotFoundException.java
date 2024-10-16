package com.ac.OneBlood.medical.exception.customExceptions;

public class DoctorNotFoundException extends RuntimeException {
    private static final String DOCTOR_NOT_FOUND_MESSAGE = "Doctor with id %s not found in the db";
    public DoctorNotFoundException(Long id) {
        super(String.format(DOCTOR_NOT_FOUND_MESSAGE, id));
    }
}
