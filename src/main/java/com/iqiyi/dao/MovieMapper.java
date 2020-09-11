package com.iqiyi.dao;

import com.iqiyi.domain.Movie;
import com.iqiyi.domain.MovieAndType;
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

    /**
     * 删除电影表的数据
     * @param id
     */
    void deleteMovieById(int id);

    void updateMovie(Movie movie);

    void insertMovieAndType(MovieAndType mat);

    /**
     * 删除电影和电影类型中间表的数据
     * @param id 电影的Id,movieId
     */
    void deleteMovieAndTypes(int id);

    /**
     * 删除电影和演员中间表的数据
     * @param id 电影的Id,movieId
     */
    void deleteMovieAndActor(int id);
}
