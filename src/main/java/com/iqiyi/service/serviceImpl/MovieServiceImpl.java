package com.iqiyi.service.serviceImpl;

import com.iqiyi.dao.MovieMapper;
import com.iqiyi.domain.Movie;
import com.iqiyi.domain.MovieAndType;
import com.iqiyi.domain.Movietype;
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

    /**
     * 填加新的电影，包括两步
     * 向movie表中插入一条新数据，
     * 向movie_type电影类型的中间表中插入一条新数据
     * @param movie
     */
    @Override
    public void addMovie(Movie movie){
        movieMapper.addMovie(movie);
        int movieid=movie.getId();
        String movietypes =movie.getMovietypes();//获得用户勾选的电影类型
        //用户可能勾选的电影类型有多个，传到后台用逗号分隔的，把电影类型的id存入数组中
        String[] movietypeArray = movietypes.split(",");
        for(String typeid:movietypeArray){
            MovieAndType movieAndType=new MovieAndType(movieid,Integer.parseInt(typeid));
            movieMapper.insertMovieAndType(movieAndType);//向电影和类型的中间表插入数据
        }
        //两个表均插入完成
    }

    /**
     * 删除电影
     * 要删除movie表中的数据，
     * 要删除电影和类型中间表movie_type
     * 要删除电影和演员中间表movie_actor
     * @param id
     */
    @Override
    public void deleteMovieById(int id){
        movieMapper.deleteMovieAndTypes(id);
        movieMapper.deleteMovieAndActor(id);
        movieMapper.deleteMovieById(id);
    }

    /**
     * 更新电影
     * 更新电影表movie
     * 更新电影和类型的中间表movie_type
     * @param movie
     */
    @Override
    public void updateMovie(Movie movie){
        movieMapper.updateMovie(movie);
        //删除movie_type表中的记录
        movieMapper.deleteMovieAndTypes(movie.getId());
        //在movie_type表中插入movieid和movietypeid
        String movietypes=movie.getMovietypes();
        String[] movietypeArray = movietypes.split(",");
        for(String typeid:movietypeArray){
            MovieAndType movieAndType=new MovieAndType(movie.getId(),Integer.parseInt(typeid));
            movieMapper.insertMovieAndType(movieAndType);//向电影和类型的中间表插入数据
        }
    }
}