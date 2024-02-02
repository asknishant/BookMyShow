package com.bms.bookmyshow.controllers;

import com.bms.bookmyshow.dtos.CreateCustomerDTO;
import com.bms.bookmyshow.exceptions.InvalidCustomerException;
import com.bms.bookmyshow.models.Customer;
import com.bms.bookmyshow.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerDTO request) {
        validate(request);
        return customerService.createCustomer(request);
    }

    public void validate(CreateCustomerDTO request) {
        if(request.getEmail() == null) {
            throw new InvalidCustomerException();
        }
    }
}
