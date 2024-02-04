package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Seat extends BaseModel {
    private Integer rowNo;
    private Integer colNo;
    @Enumerated(EnumType.ORDINAL) // mapping to numbers
    private SeatType seatType;
    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;
}
