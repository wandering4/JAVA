package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 20:21
 * @Description: listener
 * @version: 1.0
 */

//可以监听具体的某个session对象的事件
//必须和某个session绑定后监听这一个session
@WebListener
public class MySessionBindingListener implements HttpSessionBindingListener {
    //绑定方法
    /*
    session.setAttribute("mySessionBindingListener",new MySessionBindingListener());
    */
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        System.out.println("监听器和session"+session.hashCode()+"绑定了");

    }

    //解除绑定
    /*
    1.session.invalidate();让session不可用
    2.session到达最大不活动时间，session对象回收
    3.session.removeAttribute("mySessionBindingListener");手动解除绑定
     */
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        System.out.println("监听器和session"+session.hashCode()+"解绑了");
    }
}
