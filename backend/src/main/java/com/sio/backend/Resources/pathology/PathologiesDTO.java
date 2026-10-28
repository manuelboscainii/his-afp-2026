package com.sio.backend.Resources.pathology;

import jakarta.validation.constraints.NotBlank;

public record PathologiesDTO(
        @NotBlank
        String code,

        @NotBlank
        String description
) { }
