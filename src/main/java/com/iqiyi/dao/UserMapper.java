package com.iqiyi.dao;

import com.iqiyi.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/9 14:22
 */
@Mapper
public interface UserMapper {
    void save(User user);

    List<User> findUser(User user);
}
