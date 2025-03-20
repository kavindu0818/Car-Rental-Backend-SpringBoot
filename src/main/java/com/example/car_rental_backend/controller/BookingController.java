package com.example.car_rental_backend.controller;

import com.example.car_rental_backend.dto.BookingDto;
import com.example.car_rental_backend.entity.BookingEntity;
import com.example.car_rental_backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/booking")
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addBooking(@RequestBody BookingDto bookingDto) {
        try {
            System.out.println("Received booking data: " + bookingDto);

            System.out.println("booking Details;"+  bookingDto);


            BookingDto savedBooking = bookingService.addBooking(bookingDto);

            return ResponseEntity.ok(savedBooking);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error adding booking: " + ex.getMessage());
        }

    }

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookingDto>> getAllBooking() {
        List<BookingDto>  booking = bookingService.getAllBooking();
        if (booking.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable String id) {
        try {
            System.out.println("mama print karna thanta awooooo");
            bookingService.deleteBooking(id);
            return ResponseEntity.ok("booking deleted successfully.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error deleting booking: " + ex.getMessage());
        }
    }
}
