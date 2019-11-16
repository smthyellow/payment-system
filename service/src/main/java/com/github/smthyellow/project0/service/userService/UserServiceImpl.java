package com.github.smthyellow.project0.service.userService;

import com.github.smthyellow.project0.dao.user.UserDao;
import com.github.smthyellow.project0.dao.user.UserDaoImpl;
import com.github.smthyellow.project0.model.User;

public class UserServiceImpl implements UserService {
    public static class Singleton {
        static UserService INSTANCE_HOLDER = new UserServiceImpl();
    }

    public static UserService getInstance(){
        return UserServiceImpl.Singleton.INSTANCE_HOLDER;
    }

    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public void saveUser(User user) {
        UserDaoImpl.getInstance().saveUser(user);
    }

    @Override
    public void deleteUser(User user) {
        UserDaoImpl.getInstance().deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
        UserDaoImpl.getInstance().updateUser(user);
    }

    @Override
    public User getUserByAuthUserId(long id) {
        User user = userDao.getByAuthUserId(id);
        return user;
    }
}

