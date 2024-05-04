package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 21:02
 * @Description: listener
 * @version: 1.0
 */
@WebListener
public class OnNumberListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext application = session.getServletContext();
        Object attribute = application.getAttribute("count");
        if(null==attribute){
            application.setAttribute("count",1);
        }else{
            int count=(int)attribute;
            application.setAttribute("count",++count);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext application = session.getServletContext();
        int count =(int) application.getAttribute("count");
        application.setAttribute("count",--count);
    }
}
