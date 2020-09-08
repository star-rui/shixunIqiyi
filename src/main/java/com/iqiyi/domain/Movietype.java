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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Movietype {
    private int id;
    private String movieTypeName;

    @Override
    public String toString() {
        return "Movietype{" +
                "id=" + id +
                ", movieTypeName='" + movieTypeName + '\'' +
                '}';
    }
}