package com.github.smthyellow.project0.service.authUserService;

import com.github.smthyellow.project0.dao.authUser.AuthUserDao;
import com.github.smthyellow.project0.dao.authUser.AuthUserDaoImpl;
import com.github.smthyellow.project0.dao.user.UserDao;
import com.github.smthyellow.project0.dao.user.UserDaoImpl;
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
    private UserDao userDao = UserDaoImpl.getInstance();

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
    public AuthUser totalSaveAuthUser(String firstName, String lastName, String email, String phone, String password){
        AuthUser authUser = authUserDao.saveAuthUser(
                        new AuthUser(email, password, Role.CLIENT),
                        new User(firstName, lastName, phone));
        return authUser;
    }

    @Override
    public AuthUser updateAuthUser(long authUserId, String firstName, String lastName, String email, String phone, String password){
        AuthUser authUser = authUserDao.getByAuthUserId(authUserId);
        User user = userDao.getByAuthUserId(authUserId);
        if (firstName != null) {
            user.setFirstName(firstName);
        }
        if (lastName != null) {
            user.setLastName(lastName);
        }
        if (email != null) {
            authUser.setEmail(email);
        }
        if (phone != null) {
            user.setPhone(phone);
        }
        if (password != null) {
            authUser.setPassword(password);
        }

        authUserDao.updateAuthUser(authUser,user);

        return authUser;
    }

}
