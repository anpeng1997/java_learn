package com.pengan.web.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo implements Servlet {
    /**
     * 实例化Servlet时被调用，只会调用一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    /**
     * 获取ServletConfig对象
     * Servlet的配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务，每次请求都会调用它
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service!!!!");
    }

    /**
     * 获取Servlet的一些信息（一般不会去实现它）
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 程序正常停止时，会调用该方法
     */
    @Override
    public void destroy() {

    }
}
