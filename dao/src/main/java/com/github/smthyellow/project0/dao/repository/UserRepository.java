package com.github.smthyellow.project0.dao.repository;

import com.github.smthyellow.project0.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByFirstNameAndLastName(String firstName, String lastName);
    Optional<UserEntity> findById(Long userId);

    /*@Query("select AuthUserEntity " +
            "from AuthUserEntity au " +
            "left join UserEntity ue " +
            "on AuthUserEntity " +
            "where ue.firstName =:firstName and ue.lastName =:lastName")
    List <String> getByFullName(@Param("firstName") String firstName, @Param("lastName") String lastName);*/

    @Modifying
    @Query("update UserEntity set firstName = ?1, lastName = ?2, phone = ?3 where userId = ?4")
    void updateUser(String firstName, String lastName, String phone, Long userId);

}
