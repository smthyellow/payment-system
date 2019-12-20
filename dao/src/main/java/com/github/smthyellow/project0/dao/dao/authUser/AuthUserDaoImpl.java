package com.github.smthyellow.project0.dao.dao.authUser;

import com.github.smthyellow.project0.dao.entity.UserEntity;
import com.github.smthyellow.project0.dao.repository.AuthUserRepository;
import com.github.smthyellow.project0.dao.converter.AuthUserConverter;
import com.github.smthyellow.project0.dao.entity.AuthUserEntity;
import com.github.smthyellow.project0.dao.repository.UserRepository;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Role;
import com.github.smthyellow.project0.model.UserStatus;
import com.github.smthyellow.project0.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthUserDaoImpl implements AuthUserDao {
    private static final Logger log = LoggerFactory.getLogger(AuthUserDaoImpl.class);
    private final AuthUserRepository authUserRepository;
    private final UserRepository userRepository;

    public AuthUserDaoImpl(AuthUserRepository authUserRepository, UserRepository userRepository) {
        this.authUserRepository = authUserRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Long saveAuthUser(String firstName, String lastName, String email, String phone, String password) {
        AuthUserEntity authUserEntity = new AuthUserEntity(email, password, Role.CLIENT, UserStatus.ACTIVE);
        authUserRepository.save(authUserEntity);
        Long authUserId = authUserEntity.getAuthUserId();
        UserEntity userEntity = new UserEntity(firstName, lastName, phone, authUserEntity);
        userEntity.setAuthUserEntity(authUserEntity);
        userRepository.save(userEntity);
        return authUserId;
    }

    @Override
    public AuthUser getByEmail(String email) {
        return authUserRepository.findByEmail(email)
                .map(AuthUserConverter::fromEntity)
                .orElse(null);
    }

    @Override
    public AuthUser getByAuthUserId(long authUserId) {
        return  authUserRepository.findByAuthUserId(authUserId)
                .map(AuthUserConverter::fromEntity)
                .orElse(null);
    }

    @Override
    public void updateAuthUser(AuthUser authUser, User user) {
        authUserRepository.updateAuthUser(authUser.getPassword(), authUser.getEmail(), authUser.getAuthUserId());

    }

    @Override
    public void freezeAuthUser(AuthUser authUser, UserStatus status) {
        authUserRepository.freezeAuthUser(status, authUser.getAuthUserId());
    }
}
