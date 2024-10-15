package com.ac.OneBlood.medical.service.validator;

import com.ac.OneBlood.medical.entity.Patient;
import com.ac.OneBlood.medical.entity.PatientStatus;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class EntityValidator {

    public static final int MINIMUM_AGE = 18;

    public void validatePatientAge(Patient patient) throws Exception {
        Date patientBirthdate = patient.getDateOfBirth();
        LocalDate patientLocalDate = LocalDate.of(patientBirthdate.getYear(), patientBirthdate.getMonth(), patientBirthdate.getDay());
        Period periodBetweenDates = getPeriodBetweenDateAndNow(patientLocalDate);

        if (periodBetweenDates.getYears() < MINIMUM_AGE)
        {
            throw new Exception("");
        }

    }

    public void validatePatientStatus(Patient patient) throws Exception {
        if (patient.getStatus().equals(PatientStatus.BLOCKED)) {
            throw new Exception("");
        }
        else if (patient.getStatus().equals(PatientStatus.ON_HOLD) && getLastAppointmentDate().getMonths() < 6) {
            throw new Exception("");
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
