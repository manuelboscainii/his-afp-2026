package com.sio.backend.resources;

import jakarta.validation.constraints.NotBlank;

public record PathologiesDTO(
        @NotBlank
        String code,

        @NotBlank
        String description
) { }
