package com.example.car_rental_backend.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private String carId;
    private String carDetails;
    private String customerId;
    private String startDate;
    private String endDate;
    private String paymentMethod;
    private String paymentStatus;
    private String status;
    private BigDecimal payAdvance;
    private BigDecimal totalAmount;
    private BigDecimal pricePerDay;
    private BigDecimal arrearsAmount;
    private String carIssue;

}