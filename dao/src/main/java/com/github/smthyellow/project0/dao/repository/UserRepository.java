package com.github.smthyellow.project0.dao.repository;

import com.github.smthyellow.project0.dao.entity.AuthUserEntity;
import com.github.smthyellow.project0.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findById(Long userId);

    List<UserEntity> findByFirstNameAndLastName(String firstName, String LastName);

    @Modifying
    @Query("update UserEntity set firstName = ?1, lastName = ?2, phone = ?3 where userId = ?4")
    void updateUser (String firstName, String lastName, String phone, Long userId);

}
