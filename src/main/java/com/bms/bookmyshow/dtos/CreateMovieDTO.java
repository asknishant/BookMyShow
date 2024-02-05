package com.bms.bookmyshow.dtos;

import com.bms.bookmyshow.enums.Language;
import com.bms.bookmyshow.enums.MovieFeature;
import com.bms.bookmyshow.models.Movie;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data // alternative to getters , setters, and allargs and noargs constructors.
public class CreateMovieDTO {
    private String name;
    private Double rating;
    private List<Language> languages = new ArrayList<>();
    private List<MovieFeature> movieFeatures = new ArrayList<>();

    public Movie toMovie() {
        return Movie.builder()
                .name(name)
                .ratings(rating)
                .languages(languages)
                .movieFeatures(movieFeatures)
                .build();
    }
}
