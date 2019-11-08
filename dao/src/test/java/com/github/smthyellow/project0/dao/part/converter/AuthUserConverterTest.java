package com.github.smthyellow.project0.dao.part.converter;

import com.github.smthyellow.project0.dao.part.entity.AuthUserEntity;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthUserConverterTest {
    @Test
    void fromEntityNull() {
        final AuthUser authUser = AuthUserConverter.fromEntity(null);
        assertNull(authUser);
    }

    @Test
    void fromEntityNotNull() {
        final AuthUserEntity authUserEntity = new AuthUserEntity();
        authUserEntity.setAuthUserId(1L);
        authUserEntity.setEmail("log");
        authUserEntity.setPassword("2");
        authUserEntity.setRole(Role.CLIENT);

        final AuthUser authUser = AuthUserConverter.fromEntity(authUserEntity);

        assertNotNull(authUser);
        assertEquals(authUser.getAuthUserId(), authUserEntity.getAuthUserId());
        assertEquals(authUser.getEmail(), authUserEntity.getEmail());
        assertEquals(authUser.getPassword(), authUserEntity.getPassword());
        assertEquals(authUser.getRole(), authUserEntity.getRole());
    }

    @Test
    void toEntityNull() {
        final AuthUserEntity authUser = AuthUserConverter.toEntity(null);
        assertNull(authUser);
    }

    @Test
    void toEntityNotNull() {
        final AuthUser authUser = new AuthUser(1L, "log2", "2", Role.CLIENT);

        final AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);

        assertNotNull(authUser);
        assertEquals(authUser.getAuthUserId(), authUserEntity.getAuthUserId());
        assertEquals(authUser.getEmail(), authUserEntity.getEmail());
        assertEquals(authUser.getPassword(), authUserEntity.getPassword());
        assertEquals(authUser.getRole(), authUserEntity.getRole());
    }

}