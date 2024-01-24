package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking extends BaseModel {
    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @ManyToMany // bcz a showseat can get can get cancelled then booked one booking can have many showseats and one showseat can have many bookings
    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;
    private Date bookedAt;

    private BookingStatus status;
    private List<Payment> payments = new ArrayList<>();
}
