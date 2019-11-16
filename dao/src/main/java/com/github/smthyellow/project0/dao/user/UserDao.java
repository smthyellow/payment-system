package com.github.smthyellow.project0.dao.user;

import com.github.smthyellow.project0.model.User;

public interface UserDao {
    void saveUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getByAuthUserId(long id);
}
