package com.marco.prenotazione_meeting.commands.output;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class PrenotazioneCommandOutput {
    private UUID id;
    private String nomeDipendente;
    private String nomeSala;
    private LocalDate data;
    private LocalTime oraInizio;
    private LocalTime oraFine;

    public PrenotazioneCommandOutput(UUID id, String nomeDipendente, String nomeSala, LocalDate data, LocalTime oraInizio, LocalTime oraFine) {
        this.id = id;
        this.nomeDipendente = nomeDipendente;
        this.nomeSala = nomeSala;
        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
    }

    public UUID getId() {
        return id;
    }

    public String getNomeDipendente() {
        return nomeDipendente;
    }

    public String getNomeSala() {
        return nomeSala;
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
}
