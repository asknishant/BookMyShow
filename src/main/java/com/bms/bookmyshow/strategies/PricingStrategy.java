package com.bms.bookmyshow.strategies;


import com.bms.bookmyshow.models.Booking;

public interface PricingStrategy {
    Double calculatePrice(Booking booking);
}