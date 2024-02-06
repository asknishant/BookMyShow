package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.Language;
import com.bms.bookmyshow.enums.MovieFeature;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie extends BaseModel {
    private String name;
    private Double ratings;

    @ElementCollection // whenever we store non-entity enum values we use this annotaion not @OneToMany etc.
    @Enumerated
    private List<Language> languages;

    @ElementCollection
    @Enumerated
    private List<MovieFeature> movieFeatures = new ArrayList<>();

    @OneToMany(mappedBy = "movie") // Once you have bi-dir relationship btw entities, the mappedBy is used on the M side and @JoinCoulumn on 1 side.
    @JsonBackReference
    private List<Show> shows = new ArrayList<>();
}
