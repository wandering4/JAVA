package com.service;

import org.springframework.stereotype.Service;

/**
 * 目标对象的定义
 * 没有实现任何接口
 */
@Service
public class SomeServiceNoInterface {
    public String doSome(){
        System.out.println("目标对象执行了----");
        return "Hello Cglib";
    }
    public String doSomeTwo(){
        System.out.println("doSomeTwo方法执行了");
        return "doSomeTwo";
    }
}
