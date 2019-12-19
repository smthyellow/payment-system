package com.github.smthyellow.project0.dao.dao.user;

import com.github.smthyellow.project0.model.User;

public interface UserDao {

    void saveUser(User user);

    User getByAuthUserId(long id);

    //void deleteUser(User user);

    void updateUser(User user);
}
