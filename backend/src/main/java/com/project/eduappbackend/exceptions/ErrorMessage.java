package com.project.eduappbackend.exceptions;

public class ErrorMessage extends RuntimeException {
    private String message;

    public ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
