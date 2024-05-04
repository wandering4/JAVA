package listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 20:14
 * @Description: listener
 * @version: 1.0
 */
@WebListener
public class MyApplicationListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        ServletContext servletContext = scae.getServletContext();
        System.out.println("ServletContext"+servletContext.hashCode()+"对象添加了数据");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        ServletContext servletContext = scae.getServletContext();
        System.out.println("ServletContext"+servletContext.hashCode()+"对象移除了数据");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        ServletContext servletContext = scae.getServletContext();
        System.out.println("ServletContext"+servletContext.hashCode()+"对象修改了数据");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        System.out.println("ServletContext"+servletContext.hashCode()+"对象创建并初始化了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        System.out.println("ServletContext"+servletContext.hashCode()+"对象销毁了");
    }
}
