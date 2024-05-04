package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 21:07
 * @Description: servlet
 * @version: 1.0
 */
public class Logout extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //销毁session
        session.invalidate();
    }
}
