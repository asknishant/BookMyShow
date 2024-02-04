package com.bms.bookmyshow.dtos;

import com.bms.bookmyshow.enums.MovieFeature;
import com.bms.bookmyshow.enums.SeatType;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class CreateScreenRequest {
    private String name;
    private List<MovieFeature> features = new ArrayList<>();
    private Map<SeatType, List<SeatPosition>> seatRanges = new HashMap<>();
}
