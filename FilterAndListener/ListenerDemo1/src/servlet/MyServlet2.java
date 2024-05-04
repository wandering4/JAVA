package servlet;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 17:06
 * @Description: servlet
 * @version: 1.0
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/MyServlet2.do")
public class MyServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet2 获得request对象"+req.hashCode());
        System.out.println("servlet2 invoked");
    }
}

