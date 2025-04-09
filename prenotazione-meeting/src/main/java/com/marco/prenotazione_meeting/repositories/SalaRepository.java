package com.marco.prenotazione_meeting.repositories;

import com.marco.prenotazione_meeting.entities.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalaRepository extends JpaRepository<Sala, UUID> {
}
