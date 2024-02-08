package com.bms.bookmyshow.controllers;

import com.bms.bookmyshow.dtos.CreateBookingRequest;
import com.bms.bookmyshow.models.Booking;
import com.bms.bookmyshow.services.BookingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@NoArgsConstructor
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    public Booking createBooking(@RequestBody CreateBookingRequest bookingRequest) {
        return bookingService.createBooking(bookingRequest);
    }
}
