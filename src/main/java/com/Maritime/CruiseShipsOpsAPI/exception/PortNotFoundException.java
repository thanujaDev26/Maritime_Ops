package com.Maritime.CruiseShipsOpsAPI.exception;

public class PortNotFoundException extends RuntimeException {
    public PortNotFoundException(String message) {
        super(message);
    }
}
