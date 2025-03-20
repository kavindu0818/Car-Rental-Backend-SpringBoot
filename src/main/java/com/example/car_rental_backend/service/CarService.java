package com.example.car_rental_backend.service;

import com.example.car_rental_backend.dto.CarDto;
import com.example.car_rental_backend.entity.CarEntity;

import java.util.List;

public interface CarService {

CarDto addCar(CarDto carDto);

CarDto updateCar(CarDto carDto);

List<CarDto> getAllCars();
void deleteCar(String id);
}
