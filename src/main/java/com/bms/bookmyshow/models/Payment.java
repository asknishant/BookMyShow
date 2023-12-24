package com.bms.bookmyshow.models;

import com.bms.bookmyshow.enums.PaymentMethodType;
import com.bms.bookmyshow.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel {
    private String reference;
    private Double amount;
    private PaymentMethodType providerType;
    private PaymentStatus status;
}
