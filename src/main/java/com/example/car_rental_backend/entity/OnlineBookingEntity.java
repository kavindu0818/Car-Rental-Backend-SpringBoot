package com.example.car_rental_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

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

    public OnlineBookingEntity() {
    }

    public OnlineBookingEntity(Long onlineBookingId, String carDetails, String customerId, String startDate, String endDate, String status, BigDecimal totalAmount, BigDecimal pricePerDay) {
        this.onlineBookingId = onlineBookingId;
        this.carDetails = carDetails;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.totalAmount = totalAmount;
        this.pricePerDay = pricePerDay;
    }

    public Long getOnlineBookingId() {
        return onlineBookingId;
    }

    public void setOnlineBookingId(Long onlineBookingId) {
        this.onlineBookingId = onlineBookingId;
    }

    public String getCarDetails() {
        return carDetails;
    }

    public void setCarDetails(String carDetails) {
        this.carDetails = carDetails;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(BigDecimal pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
