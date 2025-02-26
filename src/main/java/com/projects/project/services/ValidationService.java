package com.projects.project.services;

import com.projects.project.commons.Validation;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public String getValidationMessage(String validationName) {
        return Validation.valueOf(validationName).toString();
    }

}
