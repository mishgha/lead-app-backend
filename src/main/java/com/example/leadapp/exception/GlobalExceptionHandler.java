package com.example.leadapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Global exception handler for handling exceptions thrown across the whole application.
 * This class centralizes exception handling logic, specifically validation errors.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles validation exceptions thrown when method arguments annotated with validation constraints fail.
     *
     * @param ex the {@link MethodArgumentNotValidException} containing details about validation failures.
     * @return a {@link ResponseEntity} containing a structured list of validation error messages and fields,
     *         with HTTP status code 400 (Bad Request).
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<Map<String, String>>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<Map<String, String>> errorList = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            Map<String, String> singleError = new HashMap<>();
            singleError.put("errorOnField", error.getField());
            singleError.put("errorMessage", error.getDefaultMessage());
            errorList.add(singleError);
        });

        Map<String, List<Map<String, String>>> response = new HashMap<>();
        response.put("errors", errorList);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
