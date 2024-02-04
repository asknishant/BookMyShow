package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.SeatStatus;
import com.bms.bookmyshow.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated
    private SeatStatus status;
}
