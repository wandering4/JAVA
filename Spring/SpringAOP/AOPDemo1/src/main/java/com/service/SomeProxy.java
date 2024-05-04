package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xuzifan
 * @Date: 2024/4/23 - 04 - 23 - 15:07
 * @Description: com
 * @version: 1.0
 */
//需要和代理对象实现同样的接口
@Service
public class SomeProxy implements SomeService{
    @Autowired
    private SomeService target;

    /**
     * 静态代理
     * 代理对象需要增强的方法
     * @return
     */
    @Override
    public String doSome() {
        String ans=target.doSome();
        return ans.toUpperCase();
    }
}
