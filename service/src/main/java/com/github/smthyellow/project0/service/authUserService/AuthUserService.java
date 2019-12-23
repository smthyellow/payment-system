package com.github.smthyellow.project0.service.authUserService;

import com.github.smthyellow.project0.model.AuthUser;

public interface AuthUserService {

    AuthUser getByEmail(String email);

    AuthUser login(String email, String password);

    AuthUser checkExistence(String email);

    Long totalSaveAuthUser(String firstName, String lastName, String email, String phone, String password);

    void updateAuthUser(long authUserId, String firstName, String lastName, String email, String phone, String password);

}
