package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat extends BaseModel {
    private Show show;
    private Seat seat;
    private SeatType seatType;
}
