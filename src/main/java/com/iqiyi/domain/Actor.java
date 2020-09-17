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
 * @date 2020/9/6 16:43
 */

public class Actor {
    private int id;
    private String actorName;
    private Date birthday;
    private String sex;
    private String description;
    private String photo;
    //区域id，使用逗号连接的
    private String regionStr;
    //区域，因为演员和区域之间存在一对多的关系
    private List<Region> regions;

    public Actor() {
    }

    public Actor(int id, String actorName, Date birthday, String sex, String description, String photo, String regionStr, List<Region> regions) {
        this.id = id;
        this.actorName = actorName;
        this.birthday = birthday;
        this.sex = sex;
        this.description = description;
        this.photo = photo;
        this.regionStr = regionStr;
        this.regions = regions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public String getRegionStr() {
        return regionStr;
    }

    public void setRegionStr(String regionStr) {
        this.regionStr = regionStr;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", actorName='" + actorName + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", regionStr='" + regionStr + '\'' +
                ", regions=" + regions +
                '}';
    }
}