package com.projects.project.controllers.requests.auth;

import jakarta.validation.constraints.NotBlank;

public record RegisterUserRequest(
        @NotBlank String firstname,
        @NotBlank String lastname,
        @NotBlank String email,
        @NotBlank String password
){}
