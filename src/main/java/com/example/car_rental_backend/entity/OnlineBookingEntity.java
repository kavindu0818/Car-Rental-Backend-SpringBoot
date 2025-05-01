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
@Table(name = "Online_booking")
public class OnlineBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long onlineBookingId;
    private String carDetails;
    private String customerId;
    private String startDate;
    private String endDate;;
    private String status;
    private BigDecimal totalAmount;
    private BigDecimal pricePerDay;

}
