package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.BookingStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@Builder
public class Booking extends BaseModel {
    private User user;
    private Show show;
    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;
    private Date bookedAt;

    private BookingStatus status;
    private List<Payment> payments = new ArrayList<>();
}
