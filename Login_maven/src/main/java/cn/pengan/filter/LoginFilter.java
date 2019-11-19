package cn.pengan.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String username = (String) httpServletRequest.getSession().getAttribute("current_login_username");
        String uri = httpServletRequest.getRequestURI();
        if (uri.contains("/loginServlet") || uri.contains("login.jsp") || uri.contains("/verificationCodeServlet")) {
            chain.doFilter(req, resp);
        } else {
            if (username != null) {
                chain.doFilter(req, resp);
            } else {
                httpServletRequest.setAttribute("login_msg", "请登录后在操作！");
                httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest, resp);
            }
        }
    }


    public void init(FilterConfig config) throws ServletException {

    }

}
