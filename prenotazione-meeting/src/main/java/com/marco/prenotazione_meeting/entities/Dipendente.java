package com.marco.prenotazione_meeting.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "dipendenti")
@Setter
public class Dipendente {

    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String cognome;
    private String ruolo;
    @OneToMany(mappedBy = "dipendente")
    @JsonIgnore
    private List<Prenotazione> prenotazioni;

    public Dipendente() {
    }

    public Dipendente(UUID id, String nome, String cognome, String ruolo) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getRuolo() {
        return ruolo;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }
}

