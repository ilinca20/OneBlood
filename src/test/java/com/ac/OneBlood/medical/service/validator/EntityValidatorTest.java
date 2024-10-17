package com.ac.OneBlood.medical.service.validator;

import com.ac.OneBlood.medical.entity.Patient;
import com.ac.OneBlood.medical.entity.PatientStatus;
import com.ac.OneBlood.medical.exception.customExceptions.PatientInvalidDataException;
import org.junit.jupiter.api.Test;

import static jakarta.xml.bind.DatatypeConverter.parseDate;
import static org.junit.jupiter.api.Assertions.*;

class EntityValidatorTest {

    EntityValidator validator = new EntityValidator();

    @Test
    void validatePatientAgeDoesntThrowExceptionForAgeOver18() {
        assertDoesNotThrow(() -> validator.validatePatientAge(getPatient("2000-02-14")));
    }
    @Test
    void validatePatientAgeThrowsExceptionForAgeUnder18() {
       assertThrows(PatientInvalidDataException.class, () -> validator.validatePatientAge(getPatient("2023-02-14")));
    }

    @Test
    void validatePatientStatusIsEligible(){
        assertDoesNotThrow(() ->validator.validatePatientStatus(getPatient("2000-02-14")));
    }

    @Test
    void validatePatientStatusOnHold(){
        assertThrows(PatientInvalidDataException.class, () ->validator.validatePatientStatus(Patient.builder().status(PatientStatus.ON_HOLD).build()));
    }

    @Test
    void validatePatientStatusBlocked(){
        assertThrows(PatientInvalidDataException.class, () ->validator.validatePatientStatus(Patient.builder().status(PatientStatus.BLOCKED).build()));
    }

    private Patient getPatient(String birthDay){
        return Patient.builder()
                .patientId(123456L)
                .firstName("first name")
                .lastName("last name")
                .dateOfBirth(parseDate(birthDay).getTime())
                .email("email")
                .gender("female")
                .phoneNumber("555-2345")
                .status(PatientStatus.ELIGIBLE)
                .build();
    }

}