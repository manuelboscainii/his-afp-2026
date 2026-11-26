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
        PatientSex sex,

        @Size(max = 255, message = "La via puo' essere lunga massimo 255 caratteri")
        String indirizzoVia,

        @Size(max = 20, message = "Il numero civico puo' essere lungo massimo 20 caratteri")
        String indirizzoCivico,

        @Size(max = 100, message = "Il comune puo' essere lungo massimo 100 caratteri")
        String comune,

        @Size(max = 5, message = "La provincia puo' essere lunga massimo 5 caratteri, usare la sigla della provincia (es. Trento = TN)")
        String provincia

) {}
