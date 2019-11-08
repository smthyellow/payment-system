package com.github.smthyellow.project0.dao.part.entity;

import com.github.smthyellow.project0.model.Account;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class AccountEntity {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private long accountId;
    @Column(insertable = false, updatable = false)
    private long authUserId;
    private long accountNumber;
    private int balance;

    public AccountEntity() {
    }

    public AccountEntity(long authUserId, long accountNumber, int balance) {
        this.authUserId = authUserId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public AccountEntity(long accountId, long userId, long accountNumber, int balance) {
        this.authUserId = userId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountId = accountId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(long authUserId) {
        this.authUserId = authUserId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @ManyToOne()
    @JoinColumn (name = "authUserId")
    private AuthUserEntity authUserEntity;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "accountId", cascade = CascadeType.ALL)
    private Set<CardEntity> cardEntities = new HashSet<>();

    public AuthUserEntity getAuthUserEntity() {
        return authUserEntity;
    }

    public void setAuthUserEntity(AuthUserEntity authUserEntity) {
        this.authUserEntity = authUserEntity;
    }

    public Set<CardEntity> getCardEntities() {
        return cardEntities;
    }

    public void setCardEntities(Set<CardEntity> cardEntities) {
        this.cardEntities = cardEntities;
    }
}
