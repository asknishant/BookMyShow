package com.bms.bookmyshow.services;

import com.bms.bookmyshow.dtos.CreateScreenRequest;
import com.bms.bookmyshow.dtos.SeatPosition;
import com.bms.bookmyshow.enums.SeatType;
import com.bms.bookmyshow.models.Screen;
import com.bms.bookmyshow.models.Seat;
import com.bms.bookmyshow.repositories.ScreenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ScreenService {
    private SeatService seatService;
    private ScreenRepository screenRepository;

    public static List<Seat> toSeats(Screen screen, Map<SeatType, List<SeatPosition>> seatPositions) {

        return seatPositions.entrySet().stream().flatMap(entry -> {

            SeatType seatType = entry.getKey();
            List<SeatPosition> positions = entry.getValue();

            return positions
                    .stream()
                    .map(seatPosition ->
                            Seat.builder()
                                    .seatType(seatType)
                                    .rowNo(seatPosition.getRowNo())
                                    .colNo(seatPosition.getColumnNo())
                                    .screen(screen)
                                    .build());
        }).toList();
    }

    public Screen createScreen(CreateScreenRequest request) {

        Screen screenRequest = Screen.builder()
                .name(request.getName())
//                .movieFeatureList(request.getFeatures())
                .build();
        Screen initialScreen = screenRepository.save(screenRequest);

        List<Seat> seats = toSeats(initialScreen, request.getSeatRanges());
        List<Seat> savedSeats = seatService.saveAll(seats);

        Screen finalScreen = initialScreen.toBuilder().seats(savedSeats).build();

        return screenRepository.save(finalScreen);
    }

    public Screen getScreen(Long id) {
        return screenRepository.findById(id).orElse(null);
    }
}