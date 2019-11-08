package com.github.smthyellow.project0.service.authUserService;

import com.github.smthyellow.project0.dao.authUser.AuthUserDao;
import com.github.smthyellow.project0.dao.authUser.AuthUserDaoImpl;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Role;
import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.service.userService.UserService;
import com.github.smthyellow.project0.service.userService.UserServiceImpl;

public class AuthUserServiceImpl implements AuthUserService {

    private static class SingletonHolder {
        static final AuthUserService HOLDER_INSTANCE = new AuthUserServiceImpl();
    }
    public static AuthUserService getInstance() {
        return AuthUserServiceImpl.SingletonHolder.HOLDER_INSTANCE;
    }

    private AuthUserDao authUserDao = AuthUserDaoImpl.getInstance();
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public AuthUser loginUser(String email, String password){
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
        Role firstRole = Role.CLIENT;
        Long authUserId = authUserDao.saveAuthUser(email, password, firstRole);
        User user = new User(firstName, lastName, phone, authUserId);
        userService.saveUser(user);
        AuthUser authUser = new AuthUser(authUserId, email, password, firstRole);
        return authUserId;
    }

}
