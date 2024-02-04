package com.bms.bookmyshow.services;

import com.bms.bookmyshow.exceptions.DuplicateMovieFoundException;
import com.bms.bookmyshow.exceptions.MovieNotFoundException;
import com.bms.bookmyshow.models.Movie;
import com.bms.bookmyshow.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {
    private MovieRepository movieRepository;
    public Movie createMovie(Movie movie) {
        // check if movie with the same name exists or not
        Optional<Movie> existingMovie = movieRepository.findByName(movie.getName());
        if(existingMovie.isPresent()) {
            throw new DuplicateMovieFoundException(movie.getName());
        }
        return movieRepository.save(movie);
    }

    public Movie getMovie(Long movieId) {
        return movieRepository.
                findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId));
    }
}
