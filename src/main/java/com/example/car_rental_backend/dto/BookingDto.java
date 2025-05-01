package com.example.car_rental_backend.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDto {
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


