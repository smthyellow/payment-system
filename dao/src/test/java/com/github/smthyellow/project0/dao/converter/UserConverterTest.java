package com.github.smthyellow.project0.dao.converter;

import com.github.smthyellow.project0.dao.entity.UserEntity;
import com.github.smthyellow.project0.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserConverterTest {
    @Test
    void fromEntityNull() {
        final User user = UserConverter.fromEntity(null);
        assertNull(user);
    }

    /*
    @Test
    void fromEntityNotNull() {
        final UserEntity userEntity = new UserEntity();
        userEntity.setUserId(1L);
        userEntity.setFirstName("q");
        userEntity.setLastName("w");
        userEntity.setPhone("e");

        final User user = UserConverter.fromEntity(userEntity);

        assertNotNull(user);
        assertEquals(user.getUserId(), userEntity.getUserId());
        assertEquals(user.getFirstName(), userEntity.getFirstName());
        assertEquals(user.getLastName(), userEntity.getLastName());
        assertEquals(user.getPhone(), userEntity.getPhone());

    }

     */


//    private long userId;
//    private String firstName;
//    private String lastName;
//    private String phone;
//    private long authUserId;

    @Test
    void toEntityNull() {
        final UserEntity userEntity = UserConverter.toEntity(null);
        assertNull(userEntity);
    }

    @Test
    void toEntityNotNull() {
        final User user = new User(1,"q", "w", "e", 4);

        final UserEntity userEntity = UserConverter.toEntity(user);

        assertNotNull(user);
        assertEquals(user.getUserId(), userEntity.getUserId());
        assertEquals(user.getFirstName(), userEntity.getFirstName());
        assertEquals(user.getLastName(), userEntity.getLastName());
        assertEquals(user.getPhone(), userEntity.getPhone());
    }

}