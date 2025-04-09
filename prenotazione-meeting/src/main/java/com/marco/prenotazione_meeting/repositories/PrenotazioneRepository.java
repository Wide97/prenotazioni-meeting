package com.marco.prenotazione_meeting.repositories;

import com.marco.prenotazione_meeting.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;


public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
    @Query("""
                SELECT p FROM Prenotazione p
                WHERE p.sala.id = :salaId
                AND p.data = :data
                AND p.numeroPosto = :numeroPosto
                AND p.oraInizio < :oraFine
                AND p.oraFine > :oraInizio
            """)
    List<Prenotazione> findConflittiPosto(
            @Param("salaId") UUID salaId,
            @Param("data") LocalDate data,
            @Param("numeroPosto") int numeroPosto,
            @Param("oraInizio") LocalTime oraInizio,
            @Param("oraFine") LocalTime oraFine
    );

}
