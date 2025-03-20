package com.example.car_rental_backend.controller;

import com.example.car_rental_backend.dto.CarDto;
import com.example.car_rental_backend.dto.CustomerDto;
import com.example.car_rental_backend.entity.CustomerEntity;
import com.example.car_rental_backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cus")
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDto customerDto) {
        try {
            System.out.println("Received car data: " + customerDto);
            CustomerDto savedCustomer = customerService.addCustomer(customerDto);
            return ResponseEntity.ok(savedCustomer);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error adding customer: " + ex.getMessage());
        }
    }

    @PutMapping(value = "/update/{id}", consumes = "application/json", produces = "application/json")
   public ResponseEntity<?> updateCar(@PathVariable String id, @RequestBody CustomerDto customerDto) {
        try {
            System.out.println("Customer update ready");
            CustomerDto updatedCar = customerService.updateCustomer(customerDto);
            return ResponseEntity.ok(updatedCar);
       } catch (Exception ex) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                   .body("Error updating car: " + ex.getMessage());
       }
   }

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerDto>> getAllCars() {
        List<CustomerDto> customer = customerService.getCustomers();
        if (customer.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable String id) {
        try {
            System.out.println("mama print karna thanta awooooo");
            customerService.deleteCar(id);
            return ResponseEntity.ok("Car deleted successfully.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error deleting car: " + ex.getMessage());
        }
    }
}
