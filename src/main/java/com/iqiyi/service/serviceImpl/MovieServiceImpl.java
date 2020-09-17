package com.iqiyi.service.serviceImpl;

import com.iqiyi.dao.MovieMapper;
import com.iqiyi.dao.RecommendMapper;
import com.iqiyi.domain.*;
import com.iqiyi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private RecommendMapper recommendMapper;

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

    /**
     * 电影推荐列表
     * 传入当前电影的id，通过当前电影的id和后台选定的推荐方式来推荐电影
     * 首先要获得推荐方式的集合recommendList
     * 然后对这个集合进行遍历操作得到具体的推荐方式
     * 根据选定的推荐方式在movie表中查询得到对应的电影，都添加到movieList集合中
     * 返回movieList的集合
     * @param id 电影id
     * @return movieList 推荐的电影的集合
     */
    @Override
    public List<Movie> recommendMovieList(int id){
        Movie movie=movieMapper.findMovieById(id);
        List<Recommend> recommendList=recommendMapper.findAll();
        List<Movie> movieList=new ArrayList<>();
        //定义set集合来存储要被推荐的电影id，因为set集合不允许重复
        Set<Integer>movieIdList=new HashSet<>();
        for(Recommend r:recommendList){
            if(r.getId()==1){
                //按照电影类型推荐
                //查询出来前三条记录
                List<Movie> top3ByTypes=movieMapper.findTop3ByTypes(id);
                for(Movie m:top3ByTypes){
                    if(!movieIdList.contains(m.getId())){//查询出来的记录不是当前电影的
                        movieList.add(m);
                        movieIdList.add(m.getId());
                    }
                }
            }else if(r.getId()==2){
                //按照演员推荐
                List<Movie> top3ByActors=movieMapper.findTop3ByActors(id);
                for(Movie m:top3ByActors){
                    if(!movieIdList.contains(m.getId())){
                        movieList.add(m);
                        movieIdList.add(m.getId());
                    }
                }
            }else if(r.getId()==3){
                //按照导演推荐

            }
        }
        return movieList;
    }
}