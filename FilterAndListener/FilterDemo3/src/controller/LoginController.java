package controller;

import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 14:20
 * @Description: controller
 * @version: 1.0
 */
@WebServlet(urlPatterns = "/loginController.do")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("user");
        String password = req.getParameter("pwd");
        System.out.println("user:"+username);
        System.out.println("upwd:"+password);
        //链接数据库校验
        //登录成功，将信息放入Session域
        User user=new User(username,password);
        req.getSession().setAttribute("user",user);
        resp.sendRedirect("welcome.jsp");
    }
}
