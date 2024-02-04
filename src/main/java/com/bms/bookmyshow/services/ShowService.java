package com.bms.bookmyshow.services;

import com.bms.bookmyshow.dtos.CreateShowRequest;
import com.bms.bookmyshow.models.*;
import com.bms.bookmyshow.repositories.ShowRepository;
import com.bms.bookmyshow.repositories.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
public class ShowService {
    private final ShowSeatRepository showSeatRepository;
    private ScreenService screenService;
    private ShowRepository showRepository;
    private MovieService movieService;
    private SeatService seatService;

    public Show createShow(CreateShowRequest request) {

        Screen screen = screenService.getScreen(request.getScreenId());

        Movie movie = movieService.getMovie(request.getMovieId());

        Show show = Show
                .builder()
                .screen(screen)
                .startTime(request.getStartTime())
                .duration(request.getDuration())
                .movie(movie)
                .build();

        Show savedShow = showRepository.save(show);

        // Task 2
        // Get the seats in the hall using HallId
        // Create the showSeats using the savedShow
        List<Seat> seats = seatService.getAll(request.getScreenId());

        List<ShowSeat> showSeats = seats.stream()
                .map(seat ->
                        ShowSeat.builder()
                                .seat(seat)
                                .show(savedShow)
                                .build()
                ).toList();

        // Save the show seats
        showSeatRepository.saveAll(showSeats);
        // Save the show again
        return showRepository.save(savedShow.toBuilder().showSeats(showSeats).build());
    }

    public Show getShow(Long id) {
        return showRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Invalid show ID:" + id));
    }
}