package com.github.smthyellow.project0.dao.repository;

import com.github.smthyellow.project0.dao.entity.AuthUserEntity;
import com.github.smthyellow.project0.dao.entity.CardEntity;
import com.github.smthyellow.project0.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
    List<CardEntity> findByAuthUserId(Long authUserId);
    Optional<CardEntity> findByCardId(Long cardId);

    @Modifying
    @Query("update CardEntity ce set ce.cardStatus = ?1 where ce.cardId = ?2")
    void changeCardStatus(Long cardId);

}
