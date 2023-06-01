package com.sg.vendingmachine.service;

public class VendingMachineNoKeyException extends Exception {
    public VendingMachineNoKeyException(String message) {
        super(message);
    }

    public VendingMachineNoKeyException(String message,
                                              Throwable cause) {
        super(message, cause);
    }
}
