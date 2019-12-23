package com.github.smthyellow.project0.dao.dao.user;

import com.github.smthyellow.project0.model.User;

import java.util.List;

public interface UserDao {

    List<User> getByFullName(String firstName, String lastName);

    void saveUser(User user);

    User getByAuthUserId(long id);

    void updateUser(User user);
}
