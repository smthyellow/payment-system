package com.github.smthyellow.project0.service.authUserService;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Role;
import com.github.smthyellow.project0.model.User;

public interface AuthUserService {

    AuthUser loginUser(String email, String password);

    AuthUser checkExistence(String email);

    Long totalSaveAuthUser(String firstName, String lastName, String email, String phone, String password);

}
