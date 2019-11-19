package cn.pengan.dao.impl;

import cn.pengan.dao.StudentDao;
import cn.pengan.domain.Student;
import cn.pengan.domain.User;
import cn.pengan.util.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    @Override
    public List<Student> getStudents() {
        String sql = "SELECT * FROM students";
        return template.query(sql, BeanPropertyRowMapper.newInstance(Student.class));
    }

    @Override
    public int addStudent(Student student) {
        String sql = "INSERT INTO students values(null,?,?,?);";
        return template.update(sql, student.getName(), student.getAge(), student.getScore());
    }

    @Override
    public List<Student> getStudents(int pageSize, int offset) {
        String sql = "SELECT * FROM students LIMIT ? OFFSET ?;";
        return template.query(sql, BeanPropertyRowMapper.newInstance(Student.class), pageSize, offset);
    }

    @Override
    public int getStudentCount() {
        String sql = "SELECT COUNT(*) FROM students;";
        return template.queryForObject(sql, int.class);
    }

    @Override
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?;";
        return template.queryForObject(sql, BeanPropertyRowMapper.newInstance(Student.class), id);
    }

    @Override
    public int deleteStudentById(int id) {
        String sql = "delete from students where id= ?;";
        return template.update(sql, id);
    }
}
