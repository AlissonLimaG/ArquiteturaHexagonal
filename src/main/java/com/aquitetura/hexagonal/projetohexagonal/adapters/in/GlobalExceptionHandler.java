package com.aquitetura.hexagonal.projetohexagonal.adapters.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InternalBusinessException.class)
    public ResponseEntity<ErrorMesage> handleException(InternalBusinessException e) {
        return ResponseEntity
                .status(e.getStatus())
                .body(new ErrorMesage(e.getStatus().value(), e.getMessage()));
    }
}

