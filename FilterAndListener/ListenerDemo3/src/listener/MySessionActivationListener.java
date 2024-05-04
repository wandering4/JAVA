package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * @Author: xuzifan
 * @Date: 2024/4/17 - 04 - 17 - 15:05
 * @Description: listener
 * @version: 1.0
 */
public class MySessionActivationListener implements HttpSessionActivationListener, Serializable {
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("session"+se.getSession().hashCode()+"即将钝化");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {

        System.out.println("session"+se.getSession().hashCode()+"已经活化");
    }
}
