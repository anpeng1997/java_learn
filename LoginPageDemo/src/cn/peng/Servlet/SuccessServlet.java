package cn.peng.Servlet;

import cn.peng.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getAttribute("user");
        response.setContentType("text/html;charset=utf-8");
        if (user != null) {
            response.getWriter().write("登录成功，"+user.getName()+",欢迎您！");
        }else{
            response.getWriter().write("登录失败,账号或密码错误！");
        }
    }
}
