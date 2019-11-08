package com.github.smthyellow.project0.service.userService;

import com.github.smthyellow.project0.model.User;

public interface UserService {

    void saveUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUserById(Long id);
}
