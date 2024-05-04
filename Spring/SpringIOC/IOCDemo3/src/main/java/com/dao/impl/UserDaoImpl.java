package com.dao.impl;

import com.dao.UserDao;
import com.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/4/23 - 04 - 23 - 14:20
 * @Description: com.dao.impl
 * @version: 1.0
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> list() {
        List<User> list=new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(new User(i+1,"boge"+(i+1)));
        }
        return list;
    }
}
