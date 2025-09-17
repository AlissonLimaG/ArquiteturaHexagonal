package com.aquitetura.hexagonal.projetohexagonal.adapters.in;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorMesage {
    int statusCode;
    String message;
    String time;

    public ErrorMesage(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        time = LocalDateTime.now().format(formatter);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
