package com.projects.project.commons;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Validation {
    EMAIL_INVALID("Invalid email address");
    private final String message;
}
