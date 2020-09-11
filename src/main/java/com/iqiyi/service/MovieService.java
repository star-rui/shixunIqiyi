package com.iqiyi.service;

import com.iqiyi.dao.MovieMapper;
import com.iqiyi.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/7 14:48
 */
public interface MovieService {

     List<Movie> findAllMovie();

     Movie findMovieById(int id);

     Movie findMovieByName(String name);

     void addMovie(Movie movie);

     void deleteMovieById(int id);

     void updateMovie(Movie movie);
}
