package com.sio.backend.patients;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record PatientDTO(

        @NotBlank(message = "Il Codice Fiscale è obbligatorio")
        @Size(max=16, min=16, message = "Il codice fiscale deve essere di 16 caratteri")
        String codiceFiscale,

        @NotBlank(message = "Il nome è obbligatorio")
        @Size(max=100, message = "Il nome deve essere lungo massimo 100 caratteri")
        String name,

        @NotBlank(message = "Il cognome è obbligatorio")
        @Size(max=100, message = "Il cognome deve essere lungo massimo 100 caratteri")
        String cognome,

        @NotNull(message = "La data di nascita è obbligatoria")
        @PastOrPresent(message = "La data di nascita non può essere nel futuro") // La data di nascita non può essere nel futuro
        LocalDate dataNascita,

        @NotBlank(message = "Il sesso è obbligatorio")
        @Pattern(regexp = "^[MF]$", message = "Il sesso deve essere 'M' o 'F'")
        PatientSex sex
) {
}
