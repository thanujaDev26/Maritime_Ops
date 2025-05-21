package com.Maritime.CruiseShipsOpsAPI.exception;

public class ShipNotFoundException extends RuntimeException {
    public ShipNotFoundException(String message) {
      super(message);
    }
}
