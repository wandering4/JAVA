package com.service.impl;

import com.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.pojo.User;
import com.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/4/22 - 04 - 22 - 21:39
 * @Description: service.impl
 * @version: 1.0
 */
//@Component
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;

/*    @Autowired
    public UserServiceImpl(@Qualifier("userDaoImpl") UserDao userDao) {
        this.userDao = userDao;
    }*/

    public UserServiceImpl() {
    }

    @Override
    public List<User> querUser() {
        return userDao.query();
    }
}
