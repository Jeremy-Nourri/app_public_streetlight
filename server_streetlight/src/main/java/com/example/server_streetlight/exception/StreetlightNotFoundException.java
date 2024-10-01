package com.example.server_streetlight.exception;

public class StreetlightNotFoundException extends RuntimeException {
    public StreetlightNotFoundException(String message) {
        super(message);
    }
}
