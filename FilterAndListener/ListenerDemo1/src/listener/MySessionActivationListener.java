package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 20:27
 * @Description: listener
 * @version: 1.0
 */
@WebListener
public class MySessionActivationListener implements HttpSessionActivationListener {
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        //存储到本地
        System.out.println("session"+session.hashCode()+"即将钝化");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        //导入到程序
        System.out.println("session"+session.hashCode()+"活化完毕");
    }
}
