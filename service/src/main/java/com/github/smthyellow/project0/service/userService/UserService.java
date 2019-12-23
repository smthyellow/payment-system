package com.github.smthyellow.project0.service.userService;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    User getUserByAuthUserId(long id);

    void updateUser(User user);

    List<User> getByFullName(String firstName, String lastName);

}
