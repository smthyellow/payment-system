package com.github.smthyellow.project0.dao.repository;

import com.github.smthyellow.project0.dao.entity.AccountEntity;
import com.github.smthyellow.project0.dao.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferRepository extends JpaRepository<TransferEntity, Long> {
    List<TransferEntity> findByFromAccountEntity(Long fromAccountId);
    List<TransferEntity> findByToAccountEntity(Long fromAccountId);

    List<TransferEntity> findByFromAccountEntityIn(List<AccountEntity> accountIds);
    List<TransferEntity> findByToAccountEntityIn(List<AccountEntity> accountIds);

}
