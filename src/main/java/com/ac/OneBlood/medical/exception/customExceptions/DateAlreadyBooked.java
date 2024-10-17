package com.ac.OneBlood.medical.exception.customExceptions;

public class DateAlreadyBooked extends RuntimeException{

    private static final String DATE_ALREADY_BOOKED_MESSAGE = "The doctor %s already has an appointment at this date and time: %s";
    public DateAlreadyBooked(String doctorName, String dateAndHour) {
        super(String.format(DATE_ALREADY_BOOKED_MESSAGE, doctorName, dateAndHour));
    }
}
