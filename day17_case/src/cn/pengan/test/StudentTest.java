package cn.pengan.test;

import cn.pengan.domain.Student;
import cn.pengan.domain.User;
import cn.pengan.service.StudentService;
import cn.pengan.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.List;

public class StudentTest {
    private StudentService studentService = new StudentServiceImpl();

    @Test
    public void getStudents() {
        List<Student> students = studentService.getStudents();
        for (Student s :
                students) {
            System.out.println(s);
        }
    }

    @Test
    public void addStudent() {
        Student spring = new Student(null, "spring", 20, 100);
        int i = studentService.addStudent(spring);
        System.out.println(i);
    }

    @Test
    public void pagination() {
        List<Student> students = studentService.getStudents(5, 0);
        System.out.println(students);
    }

    @Test
    public void getStudentById() {
        Student studentById = studentService.getStudentById(6);
        System.out.println(studentById);
    }
    @Test
    public void getStudentCount() {
        int studentCount = studentService.getStudentCount();
        System.out.println(studentCount);
    }
}
