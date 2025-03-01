package com.projects.project.controllers.requests.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

public record RegisterUserRequest(
        @NotBlank
        @NonNull
        String firstname,

        @NotBlank
        @NonNull
        String lastname,

        @NotBlank
        @NonNull
        String email,

        @NotBlank
        @NonNull
        String password,

        @NotBlank
        @NonNull
        String phone
){}
