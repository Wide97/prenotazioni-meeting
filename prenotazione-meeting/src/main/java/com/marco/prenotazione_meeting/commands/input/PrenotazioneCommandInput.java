package com.marco.prenotazione_meeting.commands.input;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class PrenotazioneCommandInput {
    private LocalDate data;
    private LocalTime oraInizio;
    private LocalTime oraFine;
    private UUID dipendenteId;
    private UUID salaId;
    private int numeroPosto;

    public PrenotazioneCommandInput(LocalDate data, LocalTime oraInizio, LocalTime oraFine, UUID dipendenteId, UUID salaId, int numeroPosto) {
        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.dipendenteId = dipendenteId;
        this.salaId = salaId;
        this.numeroPosto = numeroPosto;
    }

    public PrenotazioneCommandInput() {
    }

    public int getNumeroPosto() {
        return numeroPosto;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getOraInizio() {
        return oraInizio;
    }

    public LocalTime getOraFine() {
        return oraFine;
    }

    public UUID getDipendenteId() {
        return dipendenteId;
    }

    public UUID getSalaId() {
        return salaId;
    }
}
