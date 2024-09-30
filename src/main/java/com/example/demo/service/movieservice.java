package com.example.demo.service;

import com.example.demo.entity.movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class movieservice {


    private final MovieRepository movieRepository;

    public movieservice(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<movie> getPopularMovies() {
        return movieRepository.findByIsPopularTrue();
    }

    public List<movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public List<movie> saved(List<movie> moviesirvice) {

        return movieRepository.saveAll(moviesirvice);
    }
    public List<movie> searchallMovies() {
        return movieRepository.findallMovies();
    }
}