package com.example.car_rental_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public BookingHistoryEntity() {
    }

    public BookingHistoryEntity(String bookingId, String statusUpdate, LocalDateTime timestamp, String carId,
                                String carDetails, String customerId, LocalDate startDate, LocalDate endDate,
                                String paymentMethod, String paymentStatus, String status, Double payAdvance,
                                Double totalAmount, Double pricePerDay, Boolean carIssue, Double payArrears) {
        this.bookingId = bookingId;
        this.statusUpdate = statusUpdate;
        this.timestamp = timestamp;
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
        this.carIssue = carIssue;
        this.payArrears = payArrears;
    }

    // Getters and Setters

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getStatusUpdate() {
        return statusUpdate;
    }

    public void setStatusUpdate(String statusUpdate) {
        this.statusUpdate = statusUpdate;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
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

    public Double getPayAdvance() {
        return payAdvance;
    }

    public void setPayAdvance(Double payAdvance) {
        this.payAdvance = payAdvance;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Boolean getCarIssue() {
        return carIssue;
    }

    public void setCarIssue(Boolean carIssue) {
        this.carIssue = carIssue;
    }

    public Double getPayArrears() {
        return payArrears;
    }

    public void setPayArrears(Double payArrears) {
        this.payArrears = payArrears;
    }
}
