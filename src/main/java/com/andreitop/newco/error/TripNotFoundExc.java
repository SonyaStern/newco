package com.andreitop.newco.error;

public class TripNotFoundExc extends Exception {
   public TripNotFoundExc() {
        super();
    }

    public String getMessage() {
        String message = "Trip's not found";
        return message;
    }
}
