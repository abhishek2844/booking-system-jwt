package com.bookmyshow.controller;

import com.bookmyshow.dto.BookingRequest;
import com.bookmyshow.entity.Booking;
import com.bookmyshow.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking book(@RequestBody BookingRequest request){
        return service.book(
                request.getUserId(),
                request.getMovieId(),
                request.getSeats()
        );
    }

    @GetMapping("/{userId}")
    public List<Booking> getBooking(@PathVariable Long userId){
        return service.getUserBookings(userId);
    }

    @DeleteMapping("/{id}")
    public void cancel(@PathVariable Long id){
        service.cancel(id);
    }
}
