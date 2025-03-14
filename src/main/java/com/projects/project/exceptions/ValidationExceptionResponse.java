package com.projects.project.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationExceptionResponse {
    private String message;
    private Map<String, String> details;
    LocalDateTime timestamp = LocalDateTime.now();
}
