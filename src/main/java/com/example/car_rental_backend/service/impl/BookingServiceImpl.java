package com.example.car_rental_backend.service.impl;
import com.example.car_rental_backend.dao.BookingDao;
import com.example.car_rental_backend.dto.BookingDto;
import com.example.car_rental_backend.entity.BookingEntity;
import com.example.car_rental_backend.entity.CarEntity;
import com.example.car_rental_backend.service.BookingService;
import com.example.car_rental_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private Mapping mapping;

    @Override
    public BookingDto addBooking(BookingDto bookingDto) {
       BookingEntity bookingEntity =bookingDao.save(mapping.toBookingEntity(bookingDto));
       return mapping.toBookingDTO(bookingEntity);
    }

    @Override
    public List<BookingDto> getAllBooking() {
        List<BookingEntity> carEntities = bookingDao.findAll();
        return carEntities.stream()
                .map(mapping::toBookingDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBooking(String id) {
        bookingDao.deleteById(id);
    }
}
