package com.bms.bookmyshow.services;

import com.bms.bookmyshow.dtos.CreateBookingRequest;
import com.bms.bookmyshow.enums.BookingStatus;
import com.bms.bookmyshow.enums.SeatStatus;
import com.bms.bookmyshow.models.Booking;
import com.bms.bookmyshow.models.Customer;
import com.bms.bookmyshow.models.Show;
import com.bms.bookmyshow.models.ShowSeat;
import com.bms.bookmyshow.repositories.BookingRepository;
import com.bms.bookmyshow.strategies.PricingStrategy;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private CustomerService customerService;
    private ShowService showService;
    private ShowSeatService showSeatService;

    private PricingStrategy pricingStrategy;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(CreateBookingRequest request) {

        // Step 1 - Get the user through ID
        // Step 1b) -If user is not present, throw error
        Customer customer = customerService.getCustomerInternal(request.getCustomerId());
        if (customer == null) {
            throw new NoSuchElementException("Invalid user ID: " + request.getCustomerId());
        }
        // Step 2 - Get the show using show ID
        // Step 2b) -If show is not present, throw error
        Show show = showService.getShow(request.getShowId());

        // Step 3 - Get the show seats using showSeat IDs
        // Step 4 - Check if all the seats are available
        List<ShowSeat> showSeats = showSeatService.getShowSeats(request.getShowSeatsId());
        for (ShowSeat seat : showSeats) {
            if (seat.getStatus() != SeatStatus.AVAILABLE) {
                throw new InvalidParameterException("Seat is not available");
            }
        }

        // Step 5 - Mark all the seats blocked
        for (ShowSeat seat : showSeats) {
            seat.setStatus(SeatStatus.LOCKED);
        }
        List<ShowSeat> savedSeats = showSeatService.saveAll(showSeats);

        // Step 7 - Create and save the booking
        Booking booking = Booking.builder()
                .customer(customer)
                .show(show)
                .seats(savedSeats)
                .status(BookingStatus.PENDING)
                .bookedAt(new Date())
                .build();

        Double amount = pricingStrategy.calculatePrice(booking);
        Booking withPrice = booking.toBuilder().amount(amount).build();

        return bookingRepository.save(withPrice);
    }
}