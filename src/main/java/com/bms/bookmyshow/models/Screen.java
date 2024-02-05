package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.MovieFeature;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Screen extends BaseModel {
    private String name;
    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();
//    @ElementCollection
//    @Enumerated
//    private List<MovieFeature> movieFeatureList = new ArrayList<>();
}
