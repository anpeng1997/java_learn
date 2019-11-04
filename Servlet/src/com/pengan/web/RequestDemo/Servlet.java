package com.pengan.web.RequestDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/login2")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取post请求报文体中的参数
//        BufferedReader reader = request.getReader();//获取字符输入流
//        String len = null;
//        while ((len = reader.readLine()) != null) {
//            System.out.println(len);
//        }

        //设置编码，否则post请求中中文参数会乱码，但在tomcat 8之后，get请求乱码就解决了
        request.setCharacterEncoding("utf-8");

        //根据参数名获取参数值
        //System.out.println("name:" + request.getParameter("name"));
        //获取所有的参数名
        System.out.println("~~~~~~~~~names~~~~~~~~~~~~~");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
        }
        //获取map参数集合
        System.out.println("~~~~~~~ParameterMap:~~~~~~~~~~~~");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keys = parameterMap.keySet();
        for (String s : keys) {
            System.out.println(s + ":  " + parameterMap.get(s)[0]);
        }

        System.out.println("attribute:"+request.getAttribute("attribute"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("请求方式" + request.getMethod());
//        System.out.println("虚拟目录路径：" + request.getContextPath());
//        System.out.println("servlet路径" + request.getServletPath());
//        System.out.println("uri:统一资源标识符" + request.getRequestURI());
//        System.out.println("url：统一资源定位符：" + request.getRequestURL());
//        System.out.println("请求的IP：" + request.getRemoteAddr());
//        Enumeration<String> headers = request.getHeaderNames();
//        while (headers.hasMoreElements()) {
//            String name = headers.nextElement();
//            System.out.println(name + ":" + request.getHeader(name));
//        }
        this.doPost(request,response);
    }
}
