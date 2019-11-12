package cn.pengan.web;

import cn.pengan.domain.Pagination;
import cn.pengan.domain.Student;
import cn.pengan.service.StudentService;
import cn.pengan.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentListServlet")
public class studentListServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNumber = request.getParameter("pageNumber") == null ? 1 : Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize = request.getParameter("pageSize") == null ? 5 : Integer.parseInt(request.getParameter("pageSize"));
        //获取总条数
        int studentCount = studentService.getStudentCount();
        //计算出总页数
        int pageTotal = studentCount % pageSize == 0 ? studentCount / pageSize : (studentCount / pageSize + 1);
        //计算出offset值
        int offset = (pageNumber - 1) * pageSize <= 0 ? 0 : (pageNumber - 1) * pageSize;
        List<Student> students = studentService.getStudents(pageSize, offset);
        Pagination paginationStudent = new Pagination(studentCount, pageTotal, pageNumber, students);
        request.setAttribute("paginationStudent", paginationStudent);
        request.getRequestDispatcher("/studentList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
