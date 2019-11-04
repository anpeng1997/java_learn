package cn.peng.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/demo1")
public class ResponseDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //设置相应码
//        response.setStatus(302);
//        //设置报文头
//        response.setHeader("localhost","/demo2");

        //简单的方式
//        response.sendRedirect("/demo2");
//        response.setContentType("text/html;charset=utf-8");
//
//        //获取字符流
//        response.getWriter().write("");
//        //获取字节流输出
//        response.getOutputStream().write("你好啊".getBytes("utf-8"));

        // this.getServletContext() == request.getServletContext(); //true

        ServletContext servletContext = this.getServletContext();
        String mime = servletContext.getMimeType("a.jpg");
        System.out.println("mime:"+mime);
        //整个容器内共享
        //servletContext.setAttribute("name","123123");

        String aPath = servletContext.getRealPath("/a.txt");//获取web根目录下文件绝对路径
        String bPath = servletContext.getRealPath("/WEB-INF/b.txt");//获取web目录下WEB-INF下的文件绝对路径
        String cPath = servletContext.getRealPath("/WEB-INF/classcs/c.txt");//src目录下的资源根目录
        String cPath2 = ResponseDemo.class.getClassLoader().getResource("c.txt").getPath();
        System.out.println("aPath:"+aPath);
        System.out.println("bPath:"+bPath);
        System.out.println("cPath:"+cPath);
        System.out.println("cPath2:"+cPath2);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
