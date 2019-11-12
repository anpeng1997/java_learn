package cn.pengan.dao.impl;

import cn.pengan.dao.UserDao;
import cn.pengan.domain.User;
import cn.pengan.util.JDBCUtil;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());

    @Override
    public User login(User user) {
        String sql = "select * from t_user where name = ? and password = ?";
        User result = null;
        try {
            result = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getName(), user.getPassword());
        } catch (EmptyResultDataAccessException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
