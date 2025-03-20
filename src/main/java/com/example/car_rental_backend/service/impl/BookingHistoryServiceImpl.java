package com.example.car_rental_backend.service.impl;
import com.example.car_rental_backend.dao.BookingHistoryDao;
import com.example.car_rental_backend.dto.BookingHistoryDto;
import com.example.car_rental_backend.entity.BookingHistoryEntity;
import com.example.car_rental_backend.entity.CarEntity;
import com.example.car_rental_backend.service.BookingHistoryService;
import com.example.car_rental_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookingHistoryServiceImpl implements BookingHistoryService {

    @Autowired
    private BookingHistoryDao bookingHistoryDao;

    @Autowired
    private Mapping mapping;
    @Override
    public BookingHistoryDto addBookingHistory(BookingHistoryDto bookingHistoryDto) {
        BookingHistoryEntity bookingHistoryEntity1 = bookingHistoryDao.save(mapping.toBookingHistoryEntity(bookingHistoryDto));

        if (bookingHistoryEntity1 == null){
            throw new RuntimeException("Not Save Booking History");
        }
        return mapping.toBookingHistoryDTO(bookingHistoryEntity1);
    }

    @Override
    public List<BookingHistoryDto> getAllBookingHistory() {
        List<BookingHistoryEntity> carEntities = bookingHistoryDao.findAll();

        if (carEntities == null){
            throw new RuntimeException("Not Booking History");
        }
        return carEntities.stream()
                .map(mapping::toBookingHistoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBookingHistory(String id) {
         bookingHistoryDao.deleteById(id);
    }
}
