package com.iqiyi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/6 16:46
 */

public class Movie {
    private int id;
    private String movieName;
    @JsonFormat(pattern = "yyyy-MM-dd")//规定一下Json字符串的格式
    private Date showDate;
    private int timeLength;
    private String director;
    private String description;
    private String photo;
    private float rating;

    //电影和演员一对多
    private List<Actor> actors;
    //电影和类型一对多
    private String movietypes;
    private List<Movietype>movietypeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public int getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(int timeLength) {
        this.timeLength = timeLength;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void setMovietypes(String movietypes) {
        this.movietypes = movietypes;
    }

    public String getMovietypes() {
        return movietypes;
    }

    public List<Movietype> getMovietypeList() {
        return movietypeList;
    }

    public void setMovietypeList(List<Movietype> movietypeList) {
        this.movietypeList = movietypeList;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", showDate=" + showDate +
                ", timeLength=" + timeLength +
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", rating=" + rating +
                ", actors=" + actors +
                ", movietypes=" + movietypes +
                '}';
    }


}