package com.github.smthyellow.project0.service.user;

import com.github.smthyellow.project0.model.User;

public interface UserService {

    int saveUser(String firstName, String lastName, String email, String phone, String password);

    User checkExistence(String email);

    void deleteUser(User user);

    void updateUser(User user);

    public User loginUser(String email, String password);
}
