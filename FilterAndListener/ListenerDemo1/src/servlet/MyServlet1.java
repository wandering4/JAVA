package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 17:05
 * @Description: servlet
 * @version: 1.0
 */
@WebServlet(urlPatterns = "/MyServlet1.do")
public class MyServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet1 获得request对象"+req.hashCode());
        System.out.println("servlet1 invoked");
    }
}
