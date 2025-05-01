package com.example.car_rental_backend.service.impl;
import com.example.car_rental_backend.dao.CarDao;
import com.example.car_rental_backend.dto.CarDto;
import com.example.car_rental_backend.entity.CarEntity;
import com.example.car_rental_backend.service.CarService;
import com.example.car_rental_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Autowired
    private Mapping mapping;

    @Override
    public CarDto addCar(CarDto carDto) {
        CarEntity carEntity = mapping.toCarEntity(carDto);
        CarEntity savedCar = carDao.save(carEntity);

        if (savedCar == null) {
            throw new RuntimeException("Car not saved");
        }

        return mapping.toCarDTO(savedCar);
    }


    // Update an existing car
    @Override
    public CarDto updateCar(CarDto carDto) {
        Optional<CarEntity> existingCar = carDao.findById(carDto.getNumber());

        if (existingCar.isPresent()) {
            CarEntity updatedCar = existingCar.get();
            updatedCar.setName(carDto.getName());
            updatedCar.setModel(carDto.getModel());
            updatedCar.setYear(carDto.getYear());
            updatedCar.setType(carDto.getType());
            updatedCar.setPrice(carDto.getPrice());
            updatedCar.setFuel(carDto.getFuel());
            updatedCar.setSite(carDto.getSite());
            updatedCar.setImage(carDto.getImage());
            updatedCar.setAvailable(carDto.getAvailable());

            CarEntity savedCar = carDao.save(updatedCar);
            return mapping.toCarDTO(savedCar);
        }
        throw new RuntimeException("Car not found");
    }


    @Override
    public List<CarDto> getAllCars() {
        List<CarEntity> carEntities = carDao.findAll();
        return carEntities.stream()
                .map(mapping::toCarDTO)
                .collect(Collectors.toList());
    }


    @Override
    public void deleteCar(String number) {

        if (carDao.existsById(number)) {
            carDao.deleteById(number);
        } else {
            throw new RuntimeException("Car not found");
        }

    }
}
