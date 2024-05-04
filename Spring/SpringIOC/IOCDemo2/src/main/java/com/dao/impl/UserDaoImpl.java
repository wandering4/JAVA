package com.dao.impl;

import com.dao.UserDao;
import org.springframework.stereotype.Component;
import com.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/4/22 - 04 - 22 - 21:37
 * @Description: dao.impl
 * @version: 1.0
 */

//@Component
//    默认名字是首字母小写
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> query() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(i);
            user.setName("boge"+i);
            list.add(user);
        }
        return list;
    }
}
