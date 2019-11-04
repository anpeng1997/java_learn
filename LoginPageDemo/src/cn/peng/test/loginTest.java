package cn.peng.test;

import cn.peng.dao.UserDAO;
import cn.peng.domain.User;
import org.junit.Test;

import java.sql.SQLException;

public class loginTest {
    @Test
    public void test1() throws SQLException {
        UserDAO userDAO = new UserDAO();
        User loginUser = new User();
        loginUser.setName("zhansan");
        loginUser.setPassword("123123");
        User user = userDAO.login(loginUser);
        System.out.println(user);
    }
}
