package com.github.smthyellow.project0.service.user;

import com.github.smthyellow.project0.dao.user.UserDao;
import com.github.smthyellow.project0.dao.user.UserDaoImpl;
import com.github.smthyellow.project0.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    UserDaoImpl dao;

    @InjectMocks
    UserServiceImpl service;

    @Test
    void testLoginDoesntExist() {
        when(dao.getByEmail("admin")).thenReturn(null);
        User login = service.loginUser("admin", "admin");
        assertNull(login);
    }

    @Test
    void testCorrectLogin(){
        User user = new User(null, null, null, "admin", 1,
                "pass", null);
        when(dao.getByEmail("admin")).thenReturn(user);
        User login = service.loginUser("admin", "pass");
        assertNotNull(login);
        assertEquals(login.getEmail(), "admin");
        assertNotNull(login.getPassword(), "pass");
    }
}