package com.ac.OneBlood.medical.exception.customExceptions;

public class PatientInvalidDataException extends RuntimeException {
    private static final String PATIENT_INVALID_MESSAGE = "Patient data is invalid because: %s";
    public PatientInvalidDataException(String reason) {
        super(String.format(PATIENT_INVALID_MESSAGE, reason));
    }
}
