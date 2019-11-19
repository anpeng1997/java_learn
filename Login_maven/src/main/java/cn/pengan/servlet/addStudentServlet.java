package cn.pengan.servlet;

import cn.pengan.domain.Student;
import cn.pengan.service.StudentService;
import cn.pengan.service.impl.StudentServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addStudentServlet")
public class addStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Student student = new Student();
        try {
            BeanUtils.populate(student, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        StudentService studentService = new StudentServiceImpl();
        int result = studentService.addStudent(student);
        if (result <= 0) {
            request.setAttribute("add_msg","添加失败！");
        }else{
            request.setAttribute("add_msg","成功添加"+result+"条数据！");
        }
        request.getRequestDispatcher("/addStudent.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
