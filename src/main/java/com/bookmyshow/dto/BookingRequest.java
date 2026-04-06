package com.bookmyshow.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingRequest {

    private Long userId;
    private Long movieId;
    @JsonProperty("seatsBooked")
    private int seats;

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Long getUserId() {
        return userId;
    }

    public int getSeats() {
        return seats;
    }




}
