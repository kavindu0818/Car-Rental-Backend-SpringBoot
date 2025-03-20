package com.example.car_rental_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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



    public BookingEntity() {
    }

    public BookingEntity(Long bookingId, String carId, String carDetails, String customerId, String startDate, String endDate, String paymentMethod, String paymentStatus, String status, BigDecimal payAdvance, BigDecimal totalAmount, BigDecimal pricePerDay, BigDecimal arrearsAmount, String carIssue) {
        this.bookingId = bookingId;
        this.carId = carId;
        this.carDetails = carDetails;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.status = status;
        this.payAdvance = payAdvance;
        this.totalAmount = totalAmount;
        this.pricePerDay = pricePerDay;
        this.arrearsAmount = arrearsAmount;
        this.carIssue = carIssue;
//        this.bookingHistory = bookingHistoryEntity;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPayAdvance() {
        return payAdvance;
    }

    public void setPayAdvance(BigDecimal payAdvance) {
        this.payAdvance = payAdvance;
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

    public BigDecimal getArrearsAmount() {
        return arrearsAmount;
    }

    public void setArrearsAmount(BigDecimal arrearsAmount) {
        this.arrearsAmount = arrearsAmount;
    }

    public String getCarIssue() {
        return carIssue;
    }

    public void setCarIssue(String carIssue) {
        this.carIssue = carIssue;
    }

//    public BookingHistoryEntity getBookingHistoryEntity() {
//        return bookingHistory;
//    }
//
//    public void setBookingHistoryEntity(BookingHistoryEntity bookingHistoryEntity) {
//        this.bookingHistory = bookingHistoryEntity;
//    }
}
