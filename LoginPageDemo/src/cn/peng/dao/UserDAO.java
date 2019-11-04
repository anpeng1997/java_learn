package cn.peng.dao;

import cn.peng.domain.User;
import cn.peng.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/*
* User dao
* */
public class UserDAO {
    JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
    public User login(User loginUser) {
        try {
            String sql ="select * from t_user where name = ? and password =?;";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getName(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
