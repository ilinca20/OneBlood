package com.ac.OneBlood.medical.exception.customExceptions;

public class PatientNotFoundException extends RuntimeException {
    private static final String PATIENT_NOT_FOUND_MESSAGE = "Patient with id %s not found in the db";

    public PatientNotFoundException(Long id) {
        super(String.format(PATIENT_NOT_FOUND_MESSAGE, id));
    }
}
