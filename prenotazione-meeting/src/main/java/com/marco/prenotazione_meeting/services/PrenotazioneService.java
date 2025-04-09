package com.marco.prenotazione_meeting.services;

import com.marco.prenotazione_meeting.entities.Prenotazione;
import com.marco.prenotazione_meeting.exceptions.SalaOccupataException;
import com.marco.prenotazione_meeting.repositories.PrenotazioneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    private PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public Prenotazione creaPrenotazione(Prenotazione nuova) {
        List<Prenotazione> conflitti = prenotazioneRepository.findConflittiPosto(
                nuova.getSala().getId(),
                nuova.getData(),
                nuova.getNumeroPosto(),
                nuova.getOraInizio(),
                nuova.getOraFine()

        );

        if (!conflitti.isEmpty()) {
            throw new SalaOccupataException("La sala è già occupata in questa fascia oraria");
        }

        return prenotazioneRepository.save(nuova);
    }
}

