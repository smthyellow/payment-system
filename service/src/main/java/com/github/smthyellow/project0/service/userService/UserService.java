package com.github.smthyellow.project0.service.userService;

import com.github.smthyellow.project0.model.User;

public interface UserService {

    void saveUser(User user);

    User getUserByAuthUserId(long id);

    void updateUser(User user);

}
