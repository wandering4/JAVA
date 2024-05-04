package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author: xuzifan
 * @Date: 2024/4/17 - 04 - 17 - 14:52
 * @Description: controller
 * @version: 1.0
 */
@WebServlet("/loginCheckController.do")
public class LoginCheckController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        String message="";
        if(null==user){
                message="您未登录";
        }else{
            message="您已登录";
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(message);
    }
}
