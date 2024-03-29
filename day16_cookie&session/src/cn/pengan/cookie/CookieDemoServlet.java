package cn.pengan.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CookieDemoServlet")
public class CookieDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("one","onevalue");
        response.addCookie(cookie);
        cookie.setMaxAge(100); //cookie 持久化储存 seconds
        //设置-1：默认值
        //设置0：删除cookie
        cookie.setPath("/");
        cookie.setDomain(".baidu.com");
        Cookie[] cookies = request.getCookies();
        for (Cookie c :
                cookies) {
            String name = c.getName();
            String value = c.getValue();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
