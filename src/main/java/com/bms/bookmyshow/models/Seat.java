package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
}
