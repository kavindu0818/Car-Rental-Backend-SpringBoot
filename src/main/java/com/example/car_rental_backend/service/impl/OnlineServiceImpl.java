package com.example.car_rental_backend.service.impl;

import com.example.car_rental_backend.dao.BookingDao;
import com.example.car_rental_backend.dao.OnlineBookingDao;
import com.example.car_rental_backend.dto.OnlineBookingDto;
import com.example.car_rental_backend.entity.BookingEntity;
import com.example.car_rental_backend.entity.OnlineBookingEntity;
import com.example.car_rental_backend.service.OnlineBookingService;
import com.example.car_rental_backend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class OnlineServiceImpl  implements OnlineBookingService {

    @Autowired
    private OnlineBookingDao onlineBookingDao;

    @Autowired
    private Mapping mapping;


    @Override
    public OnlineBookingDto addOnlineBooking(OnlineBookingDto onlineBookingDto) {
//        System.out.println("BookingService"+onlineBookingDto.getCarDetails() + bookingDto.getCustomerId());
        // System.out.println("mapping ok "+(mapping.toBookingEntity(bookingDto)).getCustomer());
        OnlineBookingEntity onlineBookingEntity = onlineBookingDao.save(mapping.toOnlineBookingEntity(onlineBookingDto));

        return mapping.toOnlineBookingDTO(onlineBookingEntity);
    }

    @Override
    public List<OnlineBookingDto> getAllOnlineBooking() {
        List<OnlineBookingEntity> onlineBookingEntity = onlineBookingDao.findAll();
        return onlineBookingEntity.stream()
                .map(mapping::toOnlineBookingDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOnlineBooking(String id) {
        onlineBookingDao.deleteById(id);

    }
}
