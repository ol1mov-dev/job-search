package com.projects.project.exceptions.handler;

import com.projects.project.exceptions.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(ApplicationException.class)
//    public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException exception)  {
//        ErrorResponse error = ErrorResponse.builder()
//                .message(exception.getMessage())
//                .details(List.of(exception.getMessage()))
//                .build();
//        log.error(exception.getMessage(), exception);
//
//        return ResponseEntity
//                .status(exception.getHttpStatus())
//                .body(error);
//    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationException> handleBadRequests(MethodArgumentNotValidException ex)  {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        ValidationException errorResponse = ValidationException
                                            .builder()
                                            .message(ex.getMessage())
                                            .details(errors)
                                            .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
