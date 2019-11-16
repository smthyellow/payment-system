package com.github.smthyellow.project0.dao.util.part.converter;

import com.github.smthyellow.project0.dao.util.part.entity.AuthUserEntity;
import com.github.smthyellow.project0.model.AuthUser;

public class AuthUserConverter {
    public static AuthUserEntity toEntity(AuthUser authUser){
        if (authUser == null){
            return null;
        }

        final AuthUserEntity authUserEntity = new AuthUserEntity();

        authUserEntity.setAuthUserId(authUser.getAuthUserId());
        authUserEntity.setEmail(authUser.getEmail());
        authUserEntity.setPassword(authUser.getPassword());
        authUserEntity.setRole(authUser.getRole());
        return authUserEntity;
    }

    public static AuthUser fromEntity(AuthUserEntity authUserEntity){
        if (authUserEntity == null) {
            return null;
        }
        return new AuthUser(
                authUserEntity.getAuthUserId(),
                authUserEntity.getEmail(),
                authUserEntity.getPassword(),
                authUserEntity.getRole()
        );
    }
}
