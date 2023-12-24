package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.Language;
import com.bms.bookmyshow.enums.MovieFeature;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Movie extends BaseModel {
    private String name;
    private Double ratings;
    private List<Language> languages;
    private List<MovieFeature> features = new ArrayList<>();
}
