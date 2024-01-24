package com.bms.bookmyshow.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
@Entity
@Table(name = "shows")
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Integer duration;
    @OneToMany
    private List<ShowSeat> showSeats = new ArrayList<>();
    @ManyToOne
    private Screen screen;
}
