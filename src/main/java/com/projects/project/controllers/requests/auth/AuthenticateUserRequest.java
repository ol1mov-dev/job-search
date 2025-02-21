package com.projects.project.controllers.requests.auth;

import jakarta.validation.constraints.NotBlank;

public record AuthenticateUserRequest(
        @NotBlank String email,
        @NotBlank String password
) {}
