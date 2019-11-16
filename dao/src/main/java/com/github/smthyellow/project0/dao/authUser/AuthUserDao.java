package com.github.smthyellow.project0.dao.authUser;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Role;
import com.github.smthyellow.project0.model.User;

public interface AuthUserDao {

    AuthUser getByEmail(String email);

    AuthUser saveAuthUser(AuthUser authUser, User user);

    void updateAuthUser(AuthUser authUser, User user);

    void deleteAuthUser(AuthUser authUser);

    AuthUser getByAuthUserId(long authUserId);

}
