package com.github.smthyellow.project0.dao.authUser;

import com.github.smthyellow.project0.dao.util.part.entity.AuthUserEntity;
import com.github.smthyellow.project0.dao.util.HibernateUtil;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Role;
import com.github.smthyellow.project0.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthUserDaoImplTest {
    private AuthUserDao dao = AuthUserDaoImpl.getInstance();

    @Test
    void getByLoginExists() {
        AuthUser authUser = new AuthUser("2","3", Role.CLIENT);
        User user = new User("5", "6", "7");
        dao.saveAuthUser(authUser, user);

        final AuthUser finalAuthUser = dao.getByEmail("2");

        assertNotNull(user);
        assertEquals(finalAuthUser.getEmail(), "2");

    }

    /*@Test
    void getByLoginNotExist() {
        AuthUser authUser = new AuthUser("2","3", Role.CLIENT);
        User user = new User("5", "6", "7");
        dao.saveAuthUser(authUser, user);
        final AuthUser finalUser = dao.getByEmail("e");
        assertNull(user);
    }*/

    /*@Test
    void saveAuthUser() {
        AuthUser authUser = new AuthUser("2","3", Role.CLIENT);
        User user = new User("5", "6", "7");
        final AuthUser authUserId = dao.saveAuthUser(authUser, user);

        final AuthUserEntity userEntity = HibernateUtil.getSession().get(AuthUserEntity.class, authUserId);
        assertNotNull(userEntity);
        assertEquals(userEntity.getEmail(), userEntity.getEmail());
        assertEquals(userEntity.getPassword(), userEntity.getPassword());
    }*/

    /*@Test
    void updateAuthUser(){
        AuthUser authUser = new AuthUser("2","3", Role.CLIENT);
        User user = new User("5", "6", "7");
        AuthUser authUser2 = new AuthUser("8","9", Role.ADMIN);
        User user2 = new User("10", "11", "12");
        final long authUserId = dao.saveAuthUser(authUser, user);
        dao.updateAuthUser(authUser2, user2);
        final AuthUser authUserFin = dao.getByEmail("8");
        assertNotNull(authUser);
        assertEquals(authUser.getPassword(), "9");
        assertEquals(authUser.getRole(), Role.ADMIN);
    }*/
}