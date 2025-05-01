package com.example.car_rental_backend.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto {
    private String number;
    private String name;
    private String model;
    private String year;
    private String type;
    private BigDecimal price;
    private String fuel;
    private String site;
    private String image;
    private Boolean available; // Changed from String to Boolean

}
