package com.bms.bookmyshow.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long movieId) {
        super("Movie Not Found with id" + movieId);
    }
}
