package com.ac.OneBlood.medical.service.validator;

import com.ac.OneBlood.medical.entity.Patient;
import com.ac.OneBlood.medical.entity.PatientStatus;
import com.ac.OneBlood.medical.exception.customExceptions.PatientInvalidDataException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class EntityValidator {

    public static final int MINIMUM_AGE = 18;

    public void validatePatientAge(Patient patient) {
        LocalDate patientBirthdate = patient.getDateOfBirth();

        Period periodBetweenDates = getPeriodBetweenDateAndNow(patientBirthdate);

        if (periodBetweenDates.getYears() < MINIMUM_AGE)
        {
            throw new PatientInvalidDataException("age is below minimum required value");
        }

    }

    public void validatePatientStatus(Patient patient) {
        if (patient.getStatus().equals(PatientStatus.BLOCKED)) {
            throw new PatientInvalidDataException("status is blocked");
        }
        else if (patient.getStatus().equals(PatientStatus.ON_HOLD) && getLastAppointmentDate().getMonths() < 6) {
            throw new PatientInvalidDataException("status is on hold and the last appointment was less than 6 months ago");
        }
    }

    private Period getLastAppointmentDate() {
        //remove hardcoded value
        LocalDate lastAppointmentDate = LocalDate.of(2024, 5, 15);
        return getPeriodBetweenDateAndNow(lastAppointmentDate);
    }

    private Period getPeriodBetweenDateAndNow(LocalDate localDate){
        LocalDate currentLocalDate = LocalDate.now();
        return Period.between(localDate, currentLocalDate);
    }
}
