package com.example.car_rental_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    private String phone;

    private String name;

    private String email;

    private String license;

    private String address;

    // Default Constructor
    public CustomerEntity() {
    }

    // Parameterized Constructor
    public CustomerEntity(String phone, String name, String email, String license, String address) {
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.license = license;
        this.address = address;
    }

    // Getters and Setters
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // toString() Method
    @Override
    public String toString() {
        return "CustomerEntity{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", license='" + license + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
