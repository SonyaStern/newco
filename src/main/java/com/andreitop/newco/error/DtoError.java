package com.andreitop.newco.error;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.List;

public class DtoError {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public DtoError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public DtoError(HttpStatus status, String message, String errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = Arrays.asList(errors);
    }


    public HttpStatus getStatus() {
        return status;
    }
}
