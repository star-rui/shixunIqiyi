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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Actor {
    private int id;
    private String actorName;
    private Date birthday;
    private String sex;
    private String description;
    private String photo;

    //演员和区域多对多
    private List<Region> regions;
    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", actorName='" + actorName + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}