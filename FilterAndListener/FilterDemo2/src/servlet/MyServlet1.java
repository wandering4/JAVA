package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ServiceConfigurationError;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 13:52
 * @Description: servlet
 * @version: 1.0
 */
@WebServlet(name="myServlet1",urlPatterns = "/myServlet1.do")
public class MyServlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet1 service invoked");
    }
}
