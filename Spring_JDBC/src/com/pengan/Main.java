package com.pengan;

import com.pengan.domain.Student;
import com.pengan.jdbc_conn_pool_util.JDBCUtil;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSourec());

    public static void main(String[] args) throws SQLException {

    }

    @Test
    public void testUpdate() {
        int result = template.update("update students set  name=? where name =?", "pengan2233", "pengan22");
        System.out.println(result);
    }

    @Test
    public void queryToMap() {
        Map<String, Object> map = template.queryForMap(" select * from students where id =?", 4);
        System.out.println(map.toString());
    }
    @Test
    public void queryToObject(){
        Long aLong = template.queryForObject(" select count(id) from students", long.class);
        System.out.println(aLong);
    }

    @Test
    public void queryAllToList() {
        List<Map<String, Object>> students = template.queryForList("select * from students");
        System.out.println(students);
    }

    @Test
    public void queryAllToObject() {
        List<Student> students = template.query("select * from students", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setAge(resultSet.getInt("age"));
                student.setName(resultSet.getString("name"));
                student.setScore(resultSet.getInt("score"));
                return student;
            }
        });
        for (Student stu : students
        ) {
            System.out.println(stu);
        }
    }

    @Test
    public void queryAllDataAutoConversionObject() {
        String sql = "select * from students";
        List<Student> students = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

        for (Student s :
                students) {
            System.out.println(s);
        }
    }
}
