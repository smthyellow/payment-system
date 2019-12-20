package com.github.smthyellow.project0.dao.repository;

import com.github.smthyellow.project0.dao.entity.AuthUserEntity;
import com.github.smthyellow.project0.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUserEntity, Long> {
    Optional<AuthUserEntity> findByEmail(String email);
    Optional<AuthUserEntity> findByAuthUserId(Long authUserId);

    @Modifying
    @Query("update AuthUserEntity au set au.password = ?1, au.email = ?2 where au.authUserId = ?3")
    void updateAuthUser(String password, String email, Long authUserId);

    @Modifying
    @Query("update AuthUserEntity set status = ?1 where authUserId = ?2")
    void freezeAuthUser(UserStatus status, Long authUserId);
}