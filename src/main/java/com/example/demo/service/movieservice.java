package com.example.demo.service;

import com.example.demo.entity.movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    public movie findByname(String name){
    return movieRepository.findByname(name);
    }
    public List<movie> serchname(String name){
        return movieRepository.Search(name);
        }
    public List<movie> gettodayMovies() {
        LocalDate id=LocalDate.now();
        return  movieRepository.findUpMovies(id);
    }
    public List<movie> getUpdatrdMovies(){
        LocalDate ld=LocalDate.now();
        return movieRepository.findUpcomingMoviesDescending(ld);
    }

}