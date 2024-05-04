package listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 17:02
 * @Description: listener
 * @version: 1.0
 */
@WebListener
public class MyRequestListener implements ServletRequestListener , ServletRequestAttributeListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        //监听HttpServletRequest对象的销毁 仍和一个request对象销毁都会执行该方法
        ServletRequest servletRequest = sre.getServletRequest();
        System.out.println("request"+ servletRequest.hashCode()+"对象销毁了");

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //监听HttpServletRequest对象的创建并初始化 仍和一个request对象创建并初始化都会执行该方法
        ServletRequest servletRequest = sre.getServletRequest();
        System.out.println("request"+ servletRequest.hashCode()+"对象创建了");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        //任何一个request对象中调用了setAttribute方法增加数据都会调用该方法
        ServletRequest servletRequest = srae.getServletRequest();
        String name=srae.getName();
        Object value=srae.getValue();
        System.out.println("request"+servletRequest.hashCode()+"对象增加数据"+name+"="+value);

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        //任何一个request对象中调用了removeAttribute方法移除数据都会调用该方法
        ServletRequest servletRequest = srae.getServletRequest();
        String name=srae.getName();
        Object value=srae.getValue();
        System.out.println("request"+servletRequest.hashCode()+"对象移除数据"+name+"="+value);

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        //任何一个request对象中调用了setAttribute方法修改数据都会调用该方法
        //Web容器创建完后对象可能默认放入一些数据，造成修改
        ServletRequest servletRequest = srae.getServletRequest();
        String name=srae.getName();
        Object value=srae.getValue();
        Object newValue=servletRequest.getAttribute(name);
        System.out.println("request"+servletRequest.hashCode()+"对象修改数据"+name+"="+value+",设置为"+newValue);
    }
}
