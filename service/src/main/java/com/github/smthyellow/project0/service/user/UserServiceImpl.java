package com.github.smthyellow.project0.service.user;

import com.github.smthyellow.project0.dao.user.UserDao;
import com.github.smthyellow.project0.dao.user.UserDaoImpl;
import com.github.smthyellow.project0.model.User;

import static com.github.smthyellow.project0.model.Role.ADMIN;

public class UserServiceImpl implements UserService {
    public static class Singleton {
        static UserService INSTANCE_HOLDER = new UserServiceImpl();
    }

    public static UserService getInstance(){
        return UserServiceImpl.Singleton.INSTANCE_HOLDER;
    }

    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public int saveUser(String firstName, String lastName, String email, String phone, String password) {
        return UserDaoImpl.getInstance().save(firstName, lastName, email, phone, password);
    }

    @Override
    public User checkExistence(String email) {
        User user = userDao.getByEmail(email);
        return user;
    }

    @Override
    public void deleteUser(User user) {
        UserDaoImpl.getInstance().delete(user);
    }

    @Override
    public void updateUser(User user) {
        UserDaoImpl.getInstance().update(user);
    }

    @Override
    public User loginUser(String email, String password) {
        User user = userDao.getByEmail(email);
        if (user == null) {
            return null;
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}

