package com.iqiyi.service.serviceImpl;

import com.iqiyi.dao.MovieMapper;
import com.iqiyi.domain.Movie;
import com.iqiyi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/7 14:49
 */
@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movie> findAllMovie(){
        return movieMapper.findAllMovie();
    }

    @Override
    public Movie findMovieById(int id){
        return movieMapper.findMovieById(id);
    }

    @Override
    public Movie findMovieByName(String name){
        return movieMapper.findMovieByName(name);
    }

    @Override
    public void addMovie(Movie movie){
         movieMapper.addMovie(movie);
    }

    @Override
    public void deleteMovieById(int id){
         movieMapper.deleteMovieById(id);
    }
}