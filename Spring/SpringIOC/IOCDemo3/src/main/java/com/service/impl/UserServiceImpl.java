package com.service.impl;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/4/23 - 04 - 23 - 14:23
 * @Description: com.service.impl
 * @version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.list();
    }
}
