package cn.pengan.service;

import cn.pengan.domain.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getStudents();
    public int addStudent(Student student);
    public List<Student> getStudents(int pageSize, int offset);
    public int getStudentCount();
    public Student getStudentById(int id);
    public int deleteStudentById(String id);
}
