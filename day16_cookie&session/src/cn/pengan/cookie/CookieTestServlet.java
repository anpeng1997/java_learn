package cn.pengan.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet("/CookieTestServlet")
public class CookieTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String dateString = simpleDateFormat.format(date);
        dateString = URLEncoder.encode(dateString, "utf-8");//url编码
        Cookie cookie = new Cookie("lastTime", dateString);
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        Cookie[] cookies = request.getCookies();
        String writeStr = "you is first to page!";
        if (cookies != null && cookies.length >= 0) {
            for (Cookie c : cookies) {
                if ("lastTime".equals(c.getName())) {
                    String value = c.getValue();
                    value = URLDecoder.decode(value, "utf-8");
                    writeStr = "上次登录的时间为：" + value;
                }
            }
        }
        response.getWriter().write(writeStr);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
