package com.bms.bookmyshow.services;

import com.bms.bookmyshow.models.Seat;
import com.bms.bookmyshow.repositories.SeatRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SeatService {
    private SeatRepository seatRepository;

    public List<Seat> saveAll(List<Seat> seats) {
        return seatRepository.saveAll(seats);
    }

    public List<Seat> getAll(Long screenId) {
        return seatRepository.findAllByScreen_Id(screenId);
    }
}