package cn.pengan.service.impl;

import cn.pengan.dao.UserDao;
import cn.pengan.dao.impl.UserDaoImpl;
import cn.pengan.domain.User;
import cn.pengan.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
