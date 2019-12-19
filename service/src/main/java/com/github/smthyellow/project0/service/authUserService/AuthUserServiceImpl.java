package com.github.smthyellow.project0.service.authUserService;

import com.github.smthyellow.project0.dao.dao.authUser.AuthUserDao;
import com.github.smthyellow.project0.dao.dao.user.UserDao;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;

public class AuthUserServiceImpl implements AuthUserService {

    private final AuthUserDao authUserDao;
    private final UserDao userDao;

    public AuthUserServiceImpl(AuthUserDao authUserDao, UserDao userDao) {
        this.authUserDao = authUserDao;
        this.userDao = userDao;
    }

    @Override
    public AuthUser login(String email, String password){
        AuthUser authUser = authUserDao.getByEmail(email);
        if (authUser == null) {
            return null;
        }
        if (authUser.getPassword().equals(password)) {
            return authUser;
        }
        return null;
    }

    @Override
    public AuthUser checkExistence(String email) {
        AuthUser authUser = authUserDao.getByEmail(email);
        return authUser;
    }

    @Override
    public Long totalSaveAuthUser(String firstName, String lastName, String email, String phone, String password){
        Long authUserId = authUserDao.saveAuthUser(firstName, lastName,  email, phone, password);
        return authUserId;
    }

    @Override
    public void updateAuthUser(long authUserId, String firstName, String lastName, String email, String phone, String password) {
        AuthUser authUser = authUserDao.getByAuthUserId(authUserId);
        User user = userDao.getByAuthUserId(authUserId);
        if (password != null) {
            authUser.setPassword(password);
        }
        if (email != null) {
            authUser.setEmail(email);
        }
        if (firstName != null) {
            user.setFirstName(firstName);
        }
        if (lastName != null) {
            user.setLastName(lastName);
        }
        if (phone != null) {
            user.setPhone(phone);
        }
        authUserDao.updateAuthUser(authUser, user);
    }

}
