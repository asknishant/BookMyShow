package com.bms.bookmyshow.services;

import com.bms.bookmyshow.dtos.CreateCustomerDTO;
import com.bms.bookmyshow.exceptions.CustomerNotFoundException;
import com.bms.bookmyshow.exceptions.EmailAlreadyExistsException;
import com.bms.bookmyshow.models.Customer;
import com.bms.bookmyshow.models.User;
import com.bms.bookmyshow.repositories.CustomerRepository;
import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    private UserService userService;
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    public Customer createCustomer(CreateCustomerDTO request) {
        // validate if email is not present
        // If present , throw an error.
        String email = request.getEmail();
        Optional<Customer> existingCustomer = customerRepository.findCustomerByEmail(email);
        if(existingCustomer.isPresent()) {
            throw new EmailAlreadyExistsException(email);
        }

        // create customer
        User user = userService.createUser(request.getUserName(), request.getPassword());
        // create customer
        Customer customer = Customer.builder()
                .city(request.getCity())
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .user(user)
                .build();
        return customerRepository.save(customer);
    }
    public Customer getCustomerInternal(Long userId) {
        return customerRepository.findById(userId).orElse(null);
    }
}
