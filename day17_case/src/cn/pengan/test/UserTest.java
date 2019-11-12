package cn.pengan.test;

import cn.pengan.domain.User;
import cn.pengan.service.UserService;
import cn.pengan.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserTest {
    private UserService userService=new UserServiceImpl();
    @Test
    public void login(){
        User user = new User("zhansan", "123123");
        User login = userService.login(user);
        System.out.println(login);
    }
}
