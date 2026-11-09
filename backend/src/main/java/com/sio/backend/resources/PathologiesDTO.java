package com.sio.backend.resources;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO per il trasferimento dei dati relativi alla patologia")
public record PathologiesDTO(

        // Schema: funzione per fornire metadati aggiuntivi per la documentazione dell'API, come descrizione, esempio e requisiti di validazione
        @Schema(
                description = "Codice univoco della patologia",
                example = "P001",
                requiredMode = Schema.RequiredMode.REQUIRED,
                pattern = "C[0-9]{2,}+$" // Pattern regex per validare il formato del codice della patologia (es. P001, P002, ecc.)
        )
        @NotBlank (message = "Il codice della patologia non può essere vuoto")
        String code,

        @Schema(
                description = "Descrizione della patologia",
                example = "Cardiologica",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank
        String description

) { }
