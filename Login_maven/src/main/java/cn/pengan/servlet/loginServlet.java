package cn.pengan.servlet;

import cn.pengan.domain.User;
import cn.pengan.service.UserService;
import cn.pengan.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String code = request.getParameter("verificationCode");
        HttpSession session = request.getSession();
        //判断验证是否正确
        String verification_code = (String) session.getAttribute("verification_code");
        //删除之前的session中的验证码
        session.removeAttribute("verification_code");
        if (verification_code == null || !verification_code.equalsIgnoreCase(code)) {
            request.setAttribute("login_msg", "验证码错误！");
            //response.sendRedirect(request.getContextPath()+"/login.jsp");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        //封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService userService = new UserServiceImpl();
        User loginResult = userService.login(user);
        if (loginResult == null) {
            request.setAttribute("login_msg", "账号或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        session.setAttribute("current_login_username", user.getName());
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
