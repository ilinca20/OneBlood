package com.ac.OneBlood.medical.exception;

import com.ac.OneBlood.medical.exception.customExceptions.AppointmentNotFoundException;
import com.ac.OneBlood.medical.exception.customExceptions.DateAlreadyBooked;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {
    private static final long ID = 12345678L;
    private static final String DATE_ALREADY_BOOKED_MESSAGE = "The doctor %s already has an appointment at this date and time: %s";
    private static final String APPOINTMENT_NOT_FOUND_MESSAGE = "Appointment with id %s not found in the db";
    public static final String NAME = "Name";
    public static final String DATE = "date";
    GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void handlerSetCorrectResponseNotFound(){
        ErrorResponse response = handler.handleNotFoundException(new AppointmentNotFoundException(ID));
        assertEquals(String.format(APPOINTMENT_NOT_FOUND_MESSAGE, ID), response.getMessage());
    }

    @Test
    void handlerSetCorrectResponseBadRequest(){
        ErrorResponse response = handler.handleInvalidDataException(new DateAlreadyBooked(NAME, DATE));
        assertEquals(String.format(DATE_ALREADY_BOOKED_MESSAGE, NAME, DATE), response.getMessage());
    }

}