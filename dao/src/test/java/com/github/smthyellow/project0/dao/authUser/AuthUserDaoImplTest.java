package com.github.smthyellow.project0.dao.authUser;

import com.github.smthyellow.project0.dao.part.entity.AuthUserEntity;
import com.github.smthyellow.project0.dao.util.HibernateUtil;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthUserDaoImplTest {
    private AuthUserDao dao = AuthUserDaoImpl.getInstance();

    @Test
    void getByLoginExists() {
        dao.saveAuthUser("q", "w", Role.CLIENT);
        final AuthUser user = dao.getByEmail("q");

        assertNotNull(user);
        assertEquals(user.getEmail(), "q");
    }

    @Test
    void getByLoginNotExist() {
        final AuthUser user = dao.getByEmail("e");
        assertNull(user);
    }

    @Test
    void saveAuthUser() {
        final long authUserId = dao.saveAuthUser("q", "w", Role.CLIENT);

        final AuthUserEntity userEntity = HibernateUtil.getSession().get(AuthUserEntity.class, authUserId);
        assertNotNull(userEntity);
        assertEquals(userEntity.getEmail(), userEntity.getEmail());
        assertEquals(userEntity.getPassword(), userEntity.getPassword());
    }

    @Test
    void updateAuthUser(){
        final long authUserId = dao.saveAuthUser("q", "w", Role.CLIENT);
        dao.updateAuthUser(new AuthUser(authUserId,"e", "r", Role.ADMIN));
        final AuthUser authUser = dao.getByEmail("e");
        assertNotNull(authUser);
        assertEquals(authUser.getPassword(), "r");
        assertEquals(authUser.getRole(), Role.ADMIN);
    }
}