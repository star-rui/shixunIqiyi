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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Recommend {
    private int id;
    private String way;
    private String advice;

    @Override
    public String toString() {
        return "Recommend{" +
                "id=" + id +
                ", way='" + way + '\'' +
                ", advice='" + advice + '\'' +
                '}';
    }
}