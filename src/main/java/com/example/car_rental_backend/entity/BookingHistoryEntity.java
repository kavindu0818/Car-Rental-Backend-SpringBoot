package com.example.car_rental_backend.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "booking_history")
public class BookingHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;
    private String bookingId;
    private String statusUpdate;
    private LocalDateTime timestamp;
    private String carId;
    private String carDetails;
    private String customerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String paymentMethod;
    private String paymentStatus;
    private String status;
    private Double payAdvance;
    private Double totalAmount;
    private Double pricePerDay;
    private Boolean carIssue;
    private Double payArrears;

}
