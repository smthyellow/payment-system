package com.github.smthyellow.project0.dao.repository;

import com.github.smthyellow.project0.dao.entity.AccountEntity;
import com.github.smthyellow.project0.model.AccountAndCardStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;



public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByAccountId(Long accountId);
    List<AccountEntity> findByAuthUserEntity(Long authUserId);
    Optional<AccountEntity> findByAccountNumber(Long accountNumber);
    List<AccountEntity> findByAuthUserEntityIn(List<Long> authUserIds);
    List<AccountEntity> findAll();

    @Modifying
    @Query("update AccountEntity ae set ae.border =?1 where ae.accountId = ?2")
    void changeBorder(int border, Long accountId);

    @Modifying
    @Query("update AccountEntity ae set ae.balance = ?1 where ae.accountId = ?2")
    void changeBalance(int balance, Long accountId);

    @Modifying
    @Query("update AccountEntity ae set ae.status = ?1 where ae.accountId = ?2")
    void changeStatus(AccountAndCardStatus status, Long accountId);

    /*private Long accountId;
    private Long accountNumber;
    private int balance;
    private int limit;
    private AccountAndCardStatus status;*/

}
