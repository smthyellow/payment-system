package com.github.smthyellow.project0.dao.part.converter;

import com.github.smthyellow.project0.dao.part.entity.UserEntity;
import com.github.smthyellow.project0.model.User;

public class UserConverter {
    public static UserEntity toEntity(User user){
        if (user == null){
            return null;
        }
        final UserEntity userEntity = new UserEntity();
        //String firstName, String lastName, String phone, String email, String password, Role role
        userEntity.setUserId(user.getUserId());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPhone(user.getPhone());

        return userEntity;
    }

    public static User fromEntity(UserEntity userEntity){
        if (userEntity == null) {
            return null;
        }
        return new User(
                userEntity.getUserId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getPhone(),
                userEntity.getAuthUserEntity().getAuthUserId()
        );
    }
}
