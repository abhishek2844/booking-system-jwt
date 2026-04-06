package com.bookmyshow.controller;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {


    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @PostMapping
    public Movie add(@RequestBody Movie movie){
        return service.add(movie);
    }

    @GetMapping
    public List<Movie> getAll(){
        return service.getAll();
    }




}
