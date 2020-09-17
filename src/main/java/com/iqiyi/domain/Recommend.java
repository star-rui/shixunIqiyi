package com.iqiyi.domain;

/**
 * TODO
 *推荐表
 * @auothor asus
 * @date 2020/9/6 16:51
 */

public class Recommend {
    private int id;
    private String way;//推荐方式
    private int isRecommend;//是否被推荐，被推荐为1,未被推荐为0

    public Recommend() {
    }

    public Recommend(int id, String way, int isRecommend) {
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

    public int isRecommend() {
        return isRecommend;
    }

    public void setRecommend(int recommend) {
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