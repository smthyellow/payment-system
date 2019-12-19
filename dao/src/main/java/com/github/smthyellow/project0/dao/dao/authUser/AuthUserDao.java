package com.github.smthyellow.project0.dao.dao.authUser;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.UserStatus;
import com.github.smthyellow.project0.model.User;

public interface AuthUserDao {
    Long saveAuthUser(String firstName, String lastName, String email, String phone, String password); //done

    AuthUser getByEmail(String email); //done

    void updateAuthUser(AuthUser authUser, User user);

    void freezeAuthUser(AuthUser authUser, UserStatus status);

    AuthUser getByAuthUserId(long authUserId);

}
