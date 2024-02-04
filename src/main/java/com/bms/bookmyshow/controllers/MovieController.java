package com.bms.bookmyshow.controllers;

import com.bms.bookmyshow.dtos.CreateMovieDTO;
import com.bms.bookmyshow.models.Movie;
import com.bms.bookmyshow.services.MovieService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {
    // create a movie - POST/movie
    @Autowired
    private MovieService movieService;
    @PostMapping
    public Movie createMovie(@RequestBody CreateMovieDTO movieRequest) {
        return movieService.createMovie(movieRequest.toMovie());
    }

    // get movie
    @GetMapping("/{movieId}")
    public Movie getMovie(@PathVariable Long movieId) {
        return movieService.getMovie(movieId);
    }
}
