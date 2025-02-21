package com.projects.project.controllers.responses.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record JwtResponse(
        @NotBlank String token
) { }
