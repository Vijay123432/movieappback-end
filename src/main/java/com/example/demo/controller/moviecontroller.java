package com.example.demo.controller;


import com.example.demo.entity.movie;
import com.example.demo.service.movieservice;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class moviecontroller {

    private final movieservice movieService;

    public moviecontroller(movieservice movieService) {
        this.movieService = movieService;
    }
   
    @GetMapping("/popular")
    public List<movie> getPopularMovies() {
        return movieService.getPopularMovies();
    }

    @GetMapping("/genre/{genre}")
    public List<movie> getMoviesByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre);
    }
    @PostMapping("save")
    public movie saved(@RequestBody movie movieservice ){
     return movieService.saved(movieservice);
    }
}