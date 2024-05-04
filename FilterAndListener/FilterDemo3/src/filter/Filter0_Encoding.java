package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 14:27
 * @Description: filter
 * @version: 1.0
 */
//处理所有乱码
@WebFilter(urlPatterns = "*.do",initParams = {@WebInitParam(name = "charset",value = "UTF-8")})
public class Filter0_Encoding implements Filter {
    private String charset;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(charset);
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        charset=filterConfig.getInitParameter("charset");
    }

    @Override
    public void destroy() {

    }
}
