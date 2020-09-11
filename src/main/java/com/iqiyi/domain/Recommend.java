package com.iqiyi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/6 16:51
 */

public class Recommend {
    private int id;
    private String way;//推荐方式
    private boolean isRecommend;//是否被推荐，被推荐为true

    public Recommend() {
    }

    public Recommend(int id, String way, boolean isRecommend) {
        this.id = id;
        this.way = way;
        this.isRecommend = isRecommend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public boolean isRecommend() {
        return isRecommend;
    }

    public void setRecommend(boolean recommend) {
        isRecommend = recommend;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "id=" + id +
                ", way='" + way + '\'' +
                ", isRecommend=" + isRecommend +
                '}';
    }
}