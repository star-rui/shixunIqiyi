package com.iqiyi.domain;

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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Movie {
    private int id;
    private String movieName;
    private Date showDate;
    private int timeLength;
    private String director;
    private String description;
    private String photo;
    private float rating;

    //电影和演员一对多
    private List<Actor> actors;
    //电影和类型一对多
    private List<Movietype> movietypes;


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