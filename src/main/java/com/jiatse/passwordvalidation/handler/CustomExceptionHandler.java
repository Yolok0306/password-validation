package com.jiatse.passwordvalidation.handler;

import com.jiatse.passwordvalidation.exception.ValidatorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ValidatorException.class)
    public ResponseEntity<String> validatorExceptionHandler(final ValidatorException validatorException) {
        final String message = "get error: ValidatorException: " + validatorException.getMessage();
        return ResponseEntity.status(400).body(message);
    }
}
