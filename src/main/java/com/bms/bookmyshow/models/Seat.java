package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.SeatType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Seat extends BaseModel {
    private String rowNo;
    private Integer colNo;
    @Enumerated(EnumType.ORDINAL) // mapping to numbers
    private SeatType seatType;
    @ManyToOne
    @JoinColumn(name = "screen_id")
    @JsonBackReference
    private Screen screen;
}
