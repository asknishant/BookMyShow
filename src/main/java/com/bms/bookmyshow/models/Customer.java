package com.bms.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Customer extends BaseModel {
    private String fullName;
    private String city;
    private String phoneNumber;
    private String email;
    @OneToOne
    private User user;
}
