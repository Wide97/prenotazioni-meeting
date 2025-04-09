package com.marco.prenotazione_meeting.entities;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "prenotazioni")
@Setter
public class Prenotazione {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate data;
    private LocalTime oraInizio;
    private LocalTime oraFine;
    private int numeroPosto;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    public Prenotazione(UUID id, LocalDate data, LocalTime oraInizio, LocalTime oraFine, Dipendente dipendente, Sala sala, int numeroPosto) {
        this.id = id;
        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.dipendente = dipendente;
        this.sala = sala;
        this.numeroPosto = numeroPosto;
    }

    public Prenotazione() {
    }

    public int getNumeroPosto() {
        return numeroPosto;
    }

    public UUID getId() {
        return id;
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

    public Dipendente getDipendente() {
        return dipendente;
    }

    public Sala getSala() {
        return sala;
    }
}
