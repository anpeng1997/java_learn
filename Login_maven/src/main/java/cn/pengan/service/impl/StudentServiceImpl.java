package cn.pengan.service.impl;

import cn.pengan.dao.StudentDao;
import cn.pengan.dao.impl.StudentDaoImpl;
import cn.pengan.domain.Student;
import cn.pengan.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public List<Student> getStudents() {
        return  studentDao.getStudents();
    }

    @Override
    public int addStudent(Student student) {
        return  studentDao.addStudent(student);
    }

    @Override
    public List<Student> getStudents(int pageSize, int offset) {
        return studentDao.getStudents(pageSize,offset);
    }

    @Override
    public int getStudentCount() {
        return studentDao.getStudentCount();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public int deleteStudentById(String id) {
        int i = Integer.parseInt(id);
        return studentDao.deleteStudentById(i);
    }
}
