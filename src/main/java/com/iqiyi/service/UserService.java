package com.iqiyi.service;
import com.iqiyi.domain.User;

import java.util.List;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/9 14:16
 */
public interface UserService {

     void save(User user);

     List<User> findUser(User user);
}
