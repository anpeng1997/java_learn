package cn.pengan.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter(value = "/*",dispatcherTypes = { DispatcherType.REQUEST,DispatcherType.FORWARD })
public class filterDemo1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //是否放行的逻辑代码
        //用来增强request
        System.out.println("doFilter.....");
        //放行代码
        filterChain.doFilter(servletRequest,servletResponse);
        //放行后的代码
        //用来增强response
    }

    @Override
    public void destroy() {

    }
}
