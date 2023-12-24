package com.bms.bookmyshow.models;

import lombok.Getter;

import java.util.Date;

@Getter
public class BaseModel {
    private Long id;
    private Date updatedAt;
    private Date createdAt;
}
