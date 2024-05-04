package controller;

import listener.MySessionActivationListener;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: xuzifan
 * @Date: 2024/4/17 - 04 - 17 - 14:48
 * @Description: controller
 * @version: 1.0
 */
@WebServlet("/loginController.do")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        User user=new User(username,pwd);

        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        //绑定监听器,监听器需要也序列化
        session.setAttribute("listener",new MySessionActivationListener());
    }
}
