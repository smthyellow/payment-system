package com.github.smthyellow.project0.dao.user;

import com.github.smthyellow.project0.model.User;

public interface UserDao {
    int save(String firstName, String lastName, String email, String phone, String password);

    User getByEmail(String email);

    void delete(User user);

    void update(User user);
}
