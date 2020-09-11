package com.iqiyi.service.serviceImpl;

import com.iqiyi.dao.UserMapper;
import com.iqiyi.domain.User;
import com.iqiyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/9 14:17
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user){
        userMapper.save(user);
    }

    @Override
    public List<User> findUser(User user){
        return userMapper.findUser(user);
    }
}