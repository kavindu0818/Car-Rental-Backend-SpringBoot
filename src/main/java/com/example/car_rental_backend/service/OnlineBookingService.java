package com.example.car_rental_backend.service;

import com.example.car_rental_backend.dto.BookingDto;
import com.example.car_rental_backend.dto.OnlineBookingDto;

import java.util.List;

public interface OnlineBookingService {

    OnlineBookingDto addOnlineBooking(OnlineBookingDto onlineBookingDto);

    List<OnlineBookingDto> getAllOnlineBooking();

    void deleteOnlineBooking(String id);
}
