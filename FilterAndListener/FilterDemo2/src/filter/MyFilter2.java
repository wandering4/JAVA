package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 13:55
 * @Description: filter
 * @version: 1.0
 */
@WebFilter(urlPatterns = {"/myServlet1.do"},initParams = {@WebInitParam(name="charset",value = "UTF-8")})
public class MyFilter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter2 过滤请求");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("MyFilter2 过滤响应");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
