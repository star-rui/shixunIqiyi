package com.iqiyi.controller;

import com.iqiyi.domain.Movie;
import com.iqiyi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/7 14:46
 */
@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/findAllMovie")
    public List<Movie> findAll(){
        return movieService.findAllMovie();
    }

    @GetMapping("/findMovieById/{id}")
    public Movie findMovieById(@PathVariable int id){
        return movieService.findMovieById(id);
    }

    @GetMapping("/findMovieByName/{name}")
    public Movie findMovieByName(@PathVariable String name){
        return movieService.findMovieByName(name);
    }

    @PostMapping("addMovie")
    public void addMovie(Movie movie){
         movieService.addMovie(movie);
    }

    @GetMapping("/deleteMovieById/{id}")
    public void deleteMovieById(@PathVariable int id){
        movieService.deleteMovieById(id);
    }
}