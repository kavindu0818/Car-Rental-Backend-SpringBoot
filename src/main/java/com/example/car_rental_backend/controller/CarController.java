package com.example.car_rental_backend.controller;
import com.example.car_rental_backend.dto.CarDto;
import com.example.car_rental_backend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/car")
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addCar(@RequestBody CarDto carDto) {
        try {
            System.out.println("Received car data: " + carDto);

            
             CarDto carSave =  carService.addCar(carDto);

            return ResponseEntity.ok(carSave);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error adding car: " + ex.getMessage());
        }

    }


   @PutMapping(value = "/update/{id}", consumes = "application/json", produces = "application/json")
   public ResponseEntity<?> updateCar(@PathVariable String id, @RequestBody CarDto carDto) {
        try {
            CarDto updatedCar = carService.updateCar(carDto);
            return ResponseEntity.ok(updatedCar);
       } catch (Exception ex) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                   .body("Error updating car: " + ex.getMessage());
       }
   }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable String id) {
        try {
            System.out.println("mama print karna thanta awooooo");
            carService.deleteCar(id);
            return ResponseEntity.ok("Car deleted successfully.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error deleting car: " + ex.getMessage());
        }
    }

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> cars = carService.getAllCars();
        if (cars.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }
}
