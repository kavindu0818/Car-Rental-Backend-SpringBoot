package com.example.car_rental_backend.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {

    private String phone;
    private String name;
    private String email;
    private String license;
    private String address;


}
