package com.bms.bookmyshow.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class CreateShowRequest {
    private Long screenId;
    private Long movieId;
    private Date startTime;
    private Integer duration;
}
