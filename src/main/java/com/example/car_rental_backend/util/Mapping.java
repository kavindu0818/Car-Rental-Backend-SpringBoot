package com.example.car_rental_backend.util;
import com.example.car_rental_backend.dto.*;
import com.example.car_rental_backend.entity.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;


    public CarEntity toCarEntity(CarDto carDto) {
        return modelMapper.map(carDto, CarEntity.class);
    }

    public CarDto toCarDTO(CarEntity carEntity) {
        return modelMapper.map(carEntity, CarDto.class);
    }

    public List<CarEntity> asCarList(List<CarDto> carDtos) {
        return modelMapper.map(carDtos, new TypeToken<List<CarEntity>>() {}.getType());
    }

    public List<CarDto> asCarEntityList(List<CarEntity> carEntityList) {
        return modelMapper.map(carEntityList, new TypeToken<List<CarDto>>() {}.getType());
    }

    public BookingEntity toBookingEntity(BookingDto bookingDto) {
        return modelMapper.map(bookingDto, BookingEntity.class);
    }

    public BookingDto toBookingDTO(BookingEntity bookingEntity) {
        return modelMapper.map(bookingEntity, BookingDto.class);
    }

    public List<BookingEntity> asBookingList(List<BookingDto> bookingDtos) {
        return modelMapper.map(bookingDtos, new TypeToken<List<BookingEntity>>() {}.getType());
    }

    public List<BookingDto> asBookingEntityList(List<BookingEntity> bookingEntityList) {
        return modelMapper.map(bookingEntityList, new TypeToken<List<BookingDto>>() {}.getType());
    }

    public BookingHistoryEntity toBookingHistoryEntity(BookingHistoryDto bookingHistoryDto) {
        return modelMapper.map(bookingHistoryDto, BookingHistoryEntity.class);
    }

    public BookingHistoryDto toBookingHistoryDTO(BookingHistoryEntity bookingHistoryEntity) {
        return modelMapper.map(bookingHistoryEntity, BookingHistoryDto.class);
    }

    public List<BookingHistoryEntity> asBookingHistoryList(List<BookingHistoryDto> bookingHistoryDtos) {
        return modelMapper.map(bookingHistoryDtos, new TypeToken<List<BookingHistoryEntity>>() {}.getType());
    }

    public List<BookingHistoryDto> asBookingHistoryEntityList(List<BookingHistoryEntity> bookingHistoryEntityList) {
        return modelMapper.map(bookingHistoryEntityList, new TypeToken<List<BookingHistoryDto>>() {}.getType());
    }

    public CustomerEntity toCustomerEntity(CustomerDto customerDto) {
        return modelMapper.map(customerDto, CustomerEntity.class);
    }

    public CustomerDto toCustomerDTO(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDto.class);
    }

    public List<CustomerEntity> asCustomerList(List<CustomerDto> customerDtos) {
        return modelMapper.map(customerDtos, new TypeToken<List<CustomerEntity>>() {}.getType());
    }

    public List<CustomerDto> asCustomerEntityList(List<CustomerEntity> customerEntityList) {
        return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDto>>() {}.getType());
    }


    public OnlineBookingEntity toOnlineBookingEntity(OnlineBookingDto onlineBookingDto) {
        return modelMapper.map(onlineBookingDto, OnlineBookingEntity.class);
    }

    public OnlineBookingDto toOnlineBookingDTO(OnlineBookingEntity onlineBookingEntity) {
        return modelMapper.map(onlineBookingEntity, OnlineBookingDto.class);
    }

    public List<OnlineBookingEntity> asOnlineBookingList(List<OnlineBookingDto> onlineBookingDtos) {
        return modelMapper.map(onlineBookingDtos, new TypeToken<List<OnlineBookingEntity>>() {}.getType());
    }

    public List<OnlineBookingDto> asOnlineBookingEntityList(List<OnlineBookingEntity> onlineBookingEntityList) {
        return modelMapper.map(onlineBookingEntityList, new TypeToken<List<OnlineBookingDto>>() {}.getType());
    }
}
