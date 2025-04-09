package com.marco.prenotazione_meeting.controllers;

import com.marco.prenotazione_meeting.commands.input.PrenotazioneCommandInput;
import com.marco.prenotazione_meeting.commands.output.PrenotazioneCommandOutput;
import com.marco.prenotazione_meeting.entities.Dipendente;
import com.marco.prenotazione_meeting.entities.Prenotazione;
import com.marco.prenotazione_meeting.entities.Sala;
import com.marco.prenotazione_meeting.repositories.DipendenteRepository;
import com.marco.prenotazione_meeting.repositories.SalaRepository;
import com.marco.prenotazione_meeting.services.PrenotazioneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;
    private final DipendenteRepository dipendenteRepository;
    private final SalaRepository salaRepository;

    public PrenotazioneController(PrenotazioneService prenotazioneService, DipendenteRepository dipendenteRepository, SalaRepository salaRepository) {
        this.prenotazioneService = prenotazioneService;
        this.dipendenteRepository = dipendenteRepository;
        this.salaRepository = salaRepository;
    }

    @PostMapping
    public ResponseEntity<?> creaPrenotazione(@RequestBody PrenotazioneCommandInput input) {

        Optional<Dipendente> dipendente = dipendenteRepository.findById(input.getDipendenteId());
        Optional<Sala> sala = salaRepository.findById(input.getSalaId());

        if (dipendente.isEmpty() || sala.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Dipendente o sala non trovati.");
        }

        Prenotazione nuova = new Prenotazione(
                null,
                input.getData(),
                input.getOraInizio(),
                input.getOraFine(),
                dipendente.get(),
                sala.get(),
                input.getNumeroPosto()
        );

        Prenotazione salvata = prenotazioneService.creaPrenotazione(nuova);

        PrenotazioneCommandOutput output = new PrenotazioneCommandOutput(
                salvata.getId(),
                salvata.getDipendente().getNome() + " " + salvata.getDipendente().getCognome(),
                salvata.getSala().getNome(),
                salvata.getData(),
                salvata.getOraInizio(),
                salvata.getOraFine()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }
}


