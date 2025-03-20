package com.example.car_rental_backend.service;

import com.example.car_rental_backend.dto.CustomerDto;
import com.example.car_rental_backend.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {

    CustomerDto addCustomer(CustomerDto customerDto);
    List<CustomerDto> getCustomers();

    void deleteCar(String id);

    CustomerDto updateCustomer(CustomerDto customerDto);
}
