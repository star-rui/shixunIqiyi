package com.iqiyi.controller;

import com.iqiyi.domain.User;
import com.iqiyi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * TODO
 *
 * @auothor asus
 * @date 2020/9/9 14:14
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(User user){
        userService.save(user);
        return "注册成功";
    }


    @PostMapping("/login")
    public User login(User user, HttpServletRequest request, HttpServletResponse response){
       List<User> list= userService.findUser(user);
       if(list!=null&&list.size()>0){
           user=list.get(0);
           //得到session
           HttpSession session=request.getSession();
           //存到session中,便于操作其他功能之前用户是否已经登录
           session.setAttribute("user",user);
       }
       return user;
    }
}