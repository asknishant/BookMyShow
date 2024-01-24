package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.Language;
import com.bms.bookmyshow.enums.MovieFeature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Movie extends BaseModel {
    private String name;
    private Double ratings;

    @ElementCollection // whenever we store non-entity enum values we use this annotaion not @OneToMany etc.
    @Enumerated
    private List<Language> languages;

    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();
}
