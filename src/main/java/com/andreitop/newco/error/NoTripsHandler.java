package com.andreitop.newco.error;

public class NoTripsHandler extends RuntimeException {
    public NoTripsHandler() {
        super();
    }

    @Override
    public String getMessage() {
        return "There's no trips";
    }
}
