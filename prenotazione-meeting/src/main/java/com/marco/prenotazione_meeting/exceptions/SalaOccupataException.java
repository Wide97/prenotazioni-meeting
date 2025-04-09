package com.marco.prenotazione_meeting.exceptions;

public class SalaOccupataException extends RuntimeException {
    public SalaOccupataException(String message) {
        super(message);
    }
}
