package cn.pengan.filters;

import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = {"/addStudent.jsp",
        "/studentList.jsp",
        "/index.jsp",
        "/studentListServlet",
        "/addStudentServlet",
        "/deleteStudentServlet"},
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String current_login_username = (String) session.getAttribute("current_login_username");
        if (current_login_username != null && !"".equals(current_login_username)) {
            chain.doFilter(req, resp);
        } else {
            request.setAttribute("login_msg", "请登录后，在尝试！");
            request.getRequestDispatcher("/login.jsp").forward(request,httpResponse);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
