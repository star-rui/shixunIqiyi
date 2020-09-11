package com.iqiyi.domain;

/**
 * TODO
 *电影和电影类型的中间表
 * @auothor asus
 * @date 2020/9/9 16:01
 */
public class MovieAndType {

    //数据库中的字段
    private int movieid;
    private int typeid;

    public MovieAndType() {
    }

    public MovieAndType(int movieid, int typeid) {
        this.movieid = movieid;
        this.typeid = typeid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    @Override
    public String toString() {
        return "MovieAndType{" +
                "movieid=" + movieid +
                ", typeid=" + typeid +
                '}';
    }
}