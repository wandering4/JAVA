package filter;

import pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 16:26
 * @Description: filter
 * @version: 1.0
 */
@WebFilter(urlPatterns = "/*")
public class Filter1_Login implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //无论登录过，都要放行的资源
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        String requestURI = req.getRequestURI();
        //直接放行(包括静态资源)
        if(requestURI.contains("login.jsp")||requestURI.contains("static")||requestURI.contains("loginController.do")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //需要登录才能访问
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(null!=user){
            //登录过，放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //没登录过，跳转至登录页
            resp.sendRedirect("login.jsp");
        }


    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
