package com.bms.bookmyshow.exceptions;

public class DuplicateMovieFoundException extends RuntimeException {
    public DuplicateMovieFoundException(String name) {
        super("Movie with same name" + name + " can't be created");
    }
}
