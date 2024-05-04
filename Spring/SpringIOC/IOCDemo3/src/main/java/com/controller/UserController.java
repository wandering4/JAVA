package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/4/23 - 04 - 23 - 14:24
 * @Description: com.controller
 * @version: 1.0
 */
@Controller
public class UserController {
//    @Autowired
//    resource是JDK（版本小于11）里的，不能放在形参上,构造方法上
    @Resource(name = "userServiceImpl")
    private UserService userService;

    public List<User> list() {
        return userService.list();
    }
}
