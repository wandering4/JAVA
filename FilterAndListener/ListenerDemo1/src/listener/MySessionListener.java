package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 20:09
 * @Description: listener
 * @version: 1.0
 */
@WebListener
public class MySessionListener implements HttpSessionListener , HttpSessionAttributeListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("Session"+session.hashCode()+"对象创建了");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        System.out.println("Session"+session.hashCode()+"对象添加了数据");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        System.out.println("Session"+session.hashCode()+"对象移除数据");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        HttpSession session = se.getSession();
        System.out.println("Session"+session.hashCode()+"对象修改数据");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("Session"+session.hashCode()+"对象销毁");
    }
}
