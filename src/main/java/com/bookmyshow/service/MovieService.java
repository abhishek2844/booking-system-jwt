package com.bookmyshow.service;

import com.bookmyshow.entity.Movie;
import com.bookmyshow.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repo;

    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }

    public Movie add(Movie movie){
        return repo.save(movie);
    }

    public List<Movie> getAll(){
        return repo.findAll();
    }
    
}