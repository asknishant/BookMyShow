package com.bms.bookmyshow.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("Person with " + email + " already exists");
    }
}
