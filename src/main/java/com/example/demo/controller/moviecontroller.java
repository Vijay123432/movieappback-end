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
    @PostMapping("saveall")
    public List<movie> saved(@RequestBody List<movie> movieservice ){
     return movieService.saved(movieservice);
    }
    @GetMapping("/allmovies")
    public List<movie> searchAllMovies() {
        return movieService.searchallMovies();
}
@GetMapping("/name/{name}")
public movie getfind(@PathVariable String name){
    return movieService.findByname(name);
}
@GetMapping("/serch/{name}")
public List<movie> serchMovies(@PathVariable String name) {
    return movieService.serchname(name);
}
@GetMapping("/today")
public List<movie> gettodayMovies(){
    return movieService.gettodayMovies();
}
@GetMapping("/Update")
public List<movie> ubdateMovies(){
    return movieService.getUpdatrdMovies();
}

}