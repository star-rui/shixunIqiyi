package com.iqiyi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/6 16:50
 */

public class Movietype {
    private int id;
    private String movieTypeName;

    public Movietype() {
    }

    public Movietype(int id, String movieTypeName) {
        this.id = id;
        this.movieTypeName = movieTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieTypeName() {
        return movieTypeName;
    }

    public void setMovieTypeName(String movieTypeName) {
        this.movieTypeName = movieTypeName;
    }

    @Override
    public String toString() {
        return "Movietype{" +
                "id=" + id +
                ", movieTypeName='" + movieTypeName + '\'' +
                '}';
    }
}