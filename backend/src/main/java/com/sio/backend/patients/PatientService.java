package com.sio.backend.patients;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
class PatientService {
    private final PatientRepository repo;
    private final PatientMapper mapper;

    public PatientService(PatientRepository repo, PatientMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public PatientDTO getPatientByCodiceFiscale(String cf) {
        Patient ptTmp = repo.findByCodiceFiscaleIgnoreCase(cf)
                .orElseThrow(() -> new EntityNotFoundException("Paziente con CF " + cf + " non trovato"));

        return mapper.toDTO(ptTmp);
    }

    /**
     *
     */
    public List<PatientDTO> getPatientByNominativo(String nome, String cognome, LocalDate dataNascita, PatientSex sex) {
        return repo.findByNomeIgnoreCaseAndCognomeIgnoreCaseAndDataNascitaAndSex(
                        nome,
                        cognome,
                        dataNascita,
                        sex
                ).stream()
                .map(mapper::toDTO)
                .toList();
    }

    // Funzione per inserire o aggiornare un paziente. Se il paziente esiste già (basato sul codice fiscale), aggiorna i suoi dati; altrimenti, crea un nuovo record.
    @Transactional
    public Patient upsertPatient(PatientDTO pt) {
        return repo.findByCodiceFiscaleIgnoreCase(pt.codiceFiscale().toUpperCase().trim())
                .map(existPz -> {
                    existPz.setNome(pt.name());
                    existPz.setCognome(pt.cognome());
                    existPz.setDataNascita(pt.dataNascita());
                    existPz.setSex(pt.sex());

                    return existPz;
                })
                .orElseGet(() -> repo.save(mapper.toEntity(pt)));
    }

}
