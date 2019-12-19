package com.github.smthyellow.project0.service.authUserService;

import com.github.smthyellow.project0.dao.dao.authUser.AuthUserDao;
import com.github.smthyellow.project0.model.AuthUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthUserServiceImplTest {
    @Mock
    AuthUserDao dao;

    @InjectMocks
    AuthUserServiceImpl service;

    @Test
    void testLoginNotExist() {
        when(dao.getByEmail("email")).thenReturn(null);

        AuthUser login = service.login("email", "email");

        assertNull(login);
    }

    /*
    @Test
    void testLoginCorrect() {
        when(dao.getByEmail("email")).thenReturn(new AuthUser( "email", "pass", null));

        AuthUser userFromDb = service.login("email", "pass");

        assertNotNull(userFromDb);
        assertEquals(userFromDb.getEmail(), "email");
        assertNotNull(userFromDb.getPassword(), "pass");
    }

     */

    /*
    @Test
    void testLoginWrongPass() {
        when(dao.getByEmail("email"))
                .thenReturn(new AuthUser(1L, "email", "pass", null));
        AuthUser login = service.login("email", "pass2");
        assertNull(login);
    }

     */

}