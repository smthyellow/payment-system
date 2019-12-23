package com.github.smthyellow.project0.service.userService;

import com.github.smthyellow.project0.dao.dao.user.UserDao;
import com.github.smthyellow.project0.dao.dao.user.UserDaoImpl;
import com.github.smthyellow.project0.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    public final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUserByAuthUserId(long id) {
        User user = userDao.getByAuthUserId(id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public List<User> getByFullName(String firstName, String lastName) {
        return userDao.getByFullName(firstName, lastName);

    }
}

