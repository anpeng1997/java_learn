package cn.peng.loginTemp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String seesionCode = (String) request.getSession().getAttribute("code");
        request.getSession().removeAttribute("code");
        if (seesionCode != null && seesionCode.equalsIgnoreCase(code)) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登录成功！");
        } else {
            response.setStatus(302);
            response.sendRedirect("/day16/login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
