package com.marco.prenotazione_meeting.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "sale")
@Setter
public class Sala {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private int capienza;
    private int piano;

    @OneToMany(mappedBy = "sala")
    @JsonIgnore
    private List<Prenotazione> prenotazioni;

    public Sala() {
    }

    public Sala(UUID id, String nome, int capienza, int piano) {
        this.id = id;
        this.nome = nome;
        this.capienza = capienza;
        this.piano = piano;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCapienza() {
        return capienza;
    }

    public int getPiano() {
        return piano;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }
}
