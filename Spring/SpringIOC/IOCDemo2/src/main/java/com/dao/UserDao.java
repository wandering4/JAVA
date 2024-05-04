package com.dao;

import com.pojo.User;

import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/4/22 - 04 - 22 - 21:37
 * @Description: dao
 * @version: 1.0
 */
public interface UserDao {
    public List<User> query();
}
