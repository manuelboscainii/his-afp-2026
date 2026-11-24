package com.sio.backend.patients;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    // Trovare un paziente tramite codice fiscale
    Optional<Patient> findByCodiceFiscaleIgnoreCase(String cf);
    List<Patient> findAllByOrderByNomeAscNomeAsc();

    // Trovare un paziente tramite nome, cognome e data di nascita
    List<Patient> findByNomeIgnoreCaseAndCognomeIgnoreCaseAndDataNascitaAndSex(
            String nome,
            String cognome,
            LocalDate dataNascita,
            PatientSex sex
    );

}
