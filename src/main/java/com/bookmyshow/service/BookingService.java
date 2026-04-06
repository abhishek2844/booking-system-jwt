package com.bookmyshow.service;

import com.bookmyshow.entity.Booking;
import com.bookmyshow.entity.Movie;
import com.bookmyshow.repository.BookingRepository;
import com.bookmyshow.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepo;
    private final MovieRepository movieRepo;

    public BookingService(BookingRepository bookingRepo, MovieRepository movieRepo) {
        this.bookingRepo = bookingRepo;
        this.movieRepo = movieRepo;
    }


    public Booking book(Long userId, Long movieId, int seats){
        Movie movie = movieRepo.findById(movieId).orElseThrow(() -> new RuntimeException("Move not found"));

        if (movie.getAvailableSeats() < seats){
            throw new RuntimeException("Not Enough Seats");
        }
        movie.setAvailableSeats(movie.getAvailableSeats() - seats);
        movieRepo.save(movie);

        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setMovieId(movieId);
        booking.setSeatsBooked(seats);

        return bookingRepo.save(booking);
    }

    public List<Booking> getUserBookings(Long userId){
      return bookingRepo.findByUserId(userId);
    }

    public void cancel(Long bookingId){
         bookingRepo.deleteById(bookingId);
    }


}
