package com.controller;


import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/4/22 - 04 - 22 - 21:40
 * @Description: controller.impl
 * @version: 1.0
 */
//@Component
@Controller
public class UserController {
//    可以不需要构造器和set方法,spring容器自动实现注入
    @Autowired
    private UserService service;

    public UserService getService() {
        return service;
    }

/*    @Autowired
    @Qualifier("userServiceImpl")
    public void setService(UserService service) {
        this.service = service;
    }*/

    public void queryList(){
        List<User> users = service.querUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
