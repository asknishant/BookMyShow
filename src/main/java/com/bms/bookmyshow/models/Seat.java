package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.SeatType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat extends BaseModel {
    private Integer rowNo;
    private Integer colNo;
    private SeatType seatType;
}
