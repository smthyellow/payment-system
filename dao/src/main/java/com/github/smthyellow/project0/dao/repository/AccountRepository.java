package com.github.smthyellow.project0.dao.repository;

import com.github.smthyellow.project0.dao.entity.AccountEntity;
import com.github.smthyellow.project0.dao.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    List<AccountEntity> findByAuthUserId(Long authUserId);
    Optional<AccountEntity> findByAccountId(Long cardId);
}
