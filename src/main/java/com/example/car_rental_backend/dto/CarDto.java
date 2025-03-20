package com.example.car_rental_backend.dto;
import jakarta.persistence.Id;


import java.math.BigDecimal;

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

    // Default Constructor
    public CarDto() {
    }

    // Parameterized Constructor
    public CarDto(String number, String name, String model, String year, String type,
                     BigDecimal price, String fuel, String site,
                     String image, Boolean available) {
        this.number = number;
        this.name = name;
        this.model = model;
        this.year = year;
        this.type = type;
        this.price = price;
        this.fuel = fuel;
        this.site = site;
        this.image = image;
        this.available = available;
    }

    // Getters and Setters
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String carType) {
        this.type = carType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal rentalPrice) {
        this.price = rentalPrice;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuelType) {
        this.fuel = fuelType;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean status) {
        this.available = status;
    }

    // toString() Method
    @Override
    public String toString() {
        return "CarEntity{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", fuel='" + fuel + '\'' +
                ", site='" + site + '\'' +
                ", image='" + image + '\'' +
                ", available=" + available +
                '}';
    }
}
