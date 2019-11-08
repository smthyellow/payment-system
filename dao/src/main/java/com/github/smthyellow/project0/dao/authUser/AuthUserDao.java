package com.github.smthyellow.project0.dao.authUser;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Role;
import com.github.smthyellow.project0.model.User;

public interface AuthUserDao {

    AuthUser getByEmail(String email);

    long saveAuthUser(String email, String password, Role role);

    void updateAuthUser(AuthUser authUser);

    void deleteAuthUser(AuthUser authUser);

}
