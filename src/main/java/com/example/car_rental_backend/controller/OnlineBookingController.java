package com.example.car_rental_backend.controller;
import com.example.car_rental_backend.dto.OnlineBookingDto;
import com.example.car_rental_backend.service.OnlineBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/online")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"}, allowCredentials = "true")
public class OnlineBookingController {

    @Autowired
    private OnlineBookingService onlineBookingService;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addBooking(@RequestBody OnlineBookingDto onlineBookingDto) {
        try {
            System.out.println("online booking dto" + onlineBookingDto.getCarDetails() + onlineBookingDto.getCustomerId());
            OnlineBookingDto savedBooking = onlineBookingService.addOnlineBooking(onlineBookingDto);
            return ResponseEntity.ok(savedBooking);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error adding booking: " + ex.getMessage());
        }

    }

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OnlineBookingDto>> getAllBooking() {
        List<OnlineBookingDto>  booking = onlineBookingService.getAllOnlineBooking();
        if (booking.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable String id) {
        try {
            onlineBookingService.deleteOnlineBooking(id);
            return ResponseEntity.ok("booking deleted successfully.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error deleting booking: " + ex.getMessage());
        }
    }
}
