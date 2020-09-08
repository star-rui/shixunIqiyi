package com.iqiyi.dao;

import com.iqiyi.domain.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/7 14:47
 */
@Mapper
@Component("movieMapper")
public interface MovieMapper {

    List<Movie> findAllMovie();

    Movie findMovieById(int id);

    Movie findMovieByName(String name);

    void addMovie(Movie movie);

    void deleteMovieById(int id);
}
