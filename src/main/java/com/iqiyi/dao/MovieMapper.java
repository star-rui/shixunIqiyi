package com.iqiyi.dao;

import com.iqiyi.domain.Movie;
import com.iqiyi.domain.MovieAndType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 *对电影的数据操作
 * @auothor asus
 * @date 2020/9/7 14:47
 */
@Mapper
@Component("movieMapper")
public interface MovieMapper {

    List<Movie> findAllMovie();

    Movie findMovieById(int id);

    Movie findMovieByName(String name);

    /**
     * 插入新的电影
     * @param movie
     */
    void addMovie(Movie movie);

    /**
     * 删除电影表的数据
     * @param id
     */
    void deleteMovieById(int id);

    /**
     * 更新当前电影的数据
     * @param movie
     */
    void updateMovie(Movie movie);

    /**
     * 向movie_type的中间表插入数据
     * @param mat
     */
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

    /**
     * 用于电影的推荐，选择的推荐方式为按类型推荐
     * 根据当前电影的类型查询出与该电影类型相同的前三条电影
     * @param id 电影的id
     * @return
     */
    List<Movie>findTop3ByTypes(int id);

    /**
     * 用于电影的推荐，选择的推荐方式为按照演员推荐
     * 根据当前电影的演员查询出与该电影演员相同的前三条电影
     * @param id 电影的id
     * @return
     */
    List<Movie>findTop3ByActors(int id);
}
