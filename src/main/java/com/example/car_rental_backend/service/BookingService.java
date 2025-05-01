package com.example.car_rental_backend.service;
import com.example.car_rental_backend.dto.BookingDto;
import com.example.car_rental_backend.entity.BookingEntity;
import java.util.List;

public interface BookingService {

    BookingDto addBooking(BookingDto bookingDto);

    List<BookingDto> getAllBooking();

    void deleteBooking(String id);

}
