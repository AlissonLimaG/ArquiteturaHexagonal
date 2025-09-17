package com.aquitetura.hexagonal.projetohexagonal.adapters.in;

import org.springframework.http.HttpStatus;

public class InternalBusinessException extends RuntimeException {
    private final HttpStatus status;

    public InternalBusinessException(String message, HttpStatus status) {
        super(message);
        this.status = status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
