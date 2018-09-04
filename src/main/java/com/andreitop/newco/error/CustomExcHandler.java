package com.andreitop.newco.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExcHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({TripNotFoundExc.class})
    protected ResponseEntity<Object> handleTripNoFoundException(final TripNotFoundExc ex) {
        String error = ex.getMessage();

        DtoError dtoError = new DtoError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), error);
        return new ResponseEntity<>(dtoError, new HttpHeaders(), dtoError.getStatus());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoTripsHandler.class})
    protected ResponseEntity<Object> handleTripNoFoundException(final NoTripsHandler ex) {
        String error = ex.getMessage();

        DtoError dtoError = new DtoError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), error);
        return new ResponseEntity<>(dtoError, new HttpHeaders(), dtoError.getStatus());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();

        DtoError dtoError = new DtoError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
        return new ResponseEntity<>(dtoError, new HttpHeaders(), dtoError.getStatus());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> handleThrowable(final Throwable ex) {
        String error = "Unexpected error" + ex;

        DtoError dtoError = new DtoError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), error);
        return new ResponseEntity<>(dtoError, new HttpHeaders(), dtoError.getStatus());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ NullPointerException.class, IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity<Object> handleNulls(final RuntimeException ex) {
        DtoError dtoError = new DtoError(
                HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error 500");
        return new ResponseEntity<>(dtoError, new HttpHeaders(), dtoError.getStatus());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleAll(Exception ex) {
        DtoError dtoError = new DtoError(
                HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred");
        return new ResponseEntity<>(dtoError, new HttpHeaders(), dtoError.getStatus());
    }



}