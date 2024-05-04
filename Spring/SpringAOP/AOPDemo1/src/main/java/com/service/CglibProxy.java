package com.service;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * Cglib的代理类
 * 注意实现的MethodInterceptor是net.sf.cglib.proxy.MethodInterceptor的
 */
@Service
public class CglibProxy implements MethodInterceptor {

    private SomeServiceNoInterface target;

    public CglibProxy(SomeServiceNoInterface target) {
        this.target = target;
    }

    /**
     * 向外提供代理对象的方法
     * @return
     */
    public SomeServiceNoInterface createTarget(){
        //创建Cglib的增强器
        Enhancer enhancer=new Enhancer();
        //指定父类
        enhancer.setSuperclass(SomeServiceNoInterface.class);
        //代理后的回调对象
        enhancer.setCallback(this);
        return (SomeServiceNoInterface)enhancer.create();

    }

    /**
     * 对应的增强方法
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("start----");
        String mess=(String)method.invoke(target,objects);
        System.out.println("end----");
        return mess.toUpperCase();
    }
}
