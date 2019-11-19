package cn.pengan.servlet;

import cn.pengan.service.StudentService;
import cn.pengan.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteStudentServlet")
public class deleteStudentServlet extends HttpServlet {
    StudentService studentService =new StudentServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uids = request.getParameterValues("uid");
        for (String uid :
                uids) {
            studentService.deleteStudentById(uid);
        }
        response.sendRedirect(request.getContextPath()+"/studentListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
