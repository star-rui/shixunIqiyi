package com.iqiyi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/6 16:52
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Region {
    private int id;
    private int regionName;//区域的名字

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", regionName=" + regionName +
                '}';
    }
}