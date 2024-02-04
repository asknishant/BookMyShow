package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Booking extends BaseModel {
    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Show show;

    @ManyToMany // bcz a showseat can get can get cancelled then booked one booking can have many showseats and one showseat can have many bookings
    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;
    private Date bookedAt;

    @Enumerated
    private BookingStatus status;
    @OneToMany
    private List<Payment> payments = new ArrayList<>();
}
