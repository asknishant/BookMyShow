package com.bms.bookmyshow.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass // this tells you that this is not a JPA entity. Its just the parent class of base class entities.
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // increments
    private Long id;

    @CreatedDate
    private Date updatedAt;

    @LastModifiedBy
    private Date createdAt;
}
