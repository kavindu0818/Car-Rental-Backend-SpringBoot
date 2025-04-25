package com.example.car_rental_backend.controller;
import com.example.car_rental_backend.dto.BookingHistoryDto;
import com.example.car_rental_backend.service.BookingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/history")
@CrossOrigin(
        origins = {"http://localhost:5173", "http://localhost:5174"},
        allowCredentials = "true")

public class BookingHistoryController {

    @Autowired
    private BookingHistoryService bookingHistoryService;
    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addBookingHistory(@RequestBody BookingHistoryDto bookingHistoryDto) {
        try {
            System.out.println("Booking data backend ekata awa bn: " + bookingHistoryDto.getBookingId());


            BookingHistoryDto savedBookingHistory = bookingHistoryService.addBookingHistory(bookingHistoryDto);

            return ResponseEntity.ok(savedBookingHistory);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error adding booking history: " + ex.getMessage());
        }

    }

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookingHistoryDto>> getAllBooking() {
        List<BookingHistoryDto>  bookingHistory = bookingHistoryService.getAllBookingHistory();
        System.out.println(bookingHistory);
        if (bookingHistory.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bookingHistory);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable String id) {
        try {
            System.out.println("mama print karna thanta awooooo");
            bookingHistoryService.deleteBookingHistory(id);
            return ResponseEntity.ok("booking deleted successfully.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error deleting booking: " + ex.getMessage());
        }
    }
}
