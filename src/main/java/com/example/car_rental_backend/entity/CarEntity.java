package com.example.car_rental_backend.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cars")
public class CarEntity {

    @Id
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
