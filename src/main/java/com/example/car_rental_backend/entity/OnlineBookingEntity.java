package com.example.car_rental_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OnlineBookingEntity {

    @Id
    private String carDetails;
    private String customerId;
    private String startDate;
    private String endDate;;
    private String status;
    private BigDecimal totalAmount;
    private BigDecimal pricePerDay;
}
