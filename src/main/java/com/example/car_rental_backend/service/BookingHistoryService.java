package com.example.car_rental_backend.service;

import com.example.car_rental_backend.dto.BookingHistoryDto;
import com.example.car_rental_backend.entity.BookingHistoryEntity;
import java.util.List;

public interface BookingHistoryService {

     BookingHistoryDto addBookingHistory(BookingHistoryDto bookingHistoryDto);
    List<BookingHistoryDto> getAllBookingHistory();

    void deleteBookingHistory(String id);

}
