package Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 13:32
 * @Description: Filter
 * @version: 1.0
 */
public class MyFilter1 implements Filter {
    public MyFilter1(){
        System.out.println("MyFilter1 constructor invoked");
    }
    //过滤方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter1 doFilter过滤");
        //放行请求，交给过滤器链继续进行过滤
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("MyFilter1 doFilter对响应作出过滤");
        servletResponse.getWriter().write("<br>filter追加或删除的数据");
    }
    //初始方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter1 init invoked");
    }

    //销毁方法
    @Override
    public void destroy() {
        System.out.println("MyFilter1 de stroy invoked");
    }
}
