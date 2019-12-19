package com.github.smthyellow.project0.dao.entity;

import com.github.smthyellow.project0.model.AccountAndCardStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class AccountEntity {

    private long accountId;
    private long accountNumber;
    private int balance;
    private int limit;
    private AccountAndCardStatus status;
    private AuthUserEntity authUserEntity;
    private List<CardEntity> cardEntities = new ArrayList<>();
    private List<TransferEntity> acceptedTransferEntities = new ArrayList<>();
    private List<TransferEntity> sentTransferEntities = new ArrayList<>();

    public AccountEntity() {
    }

    public AccountEntity(long accountNumber, int balance, int limit) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.limit = limit;
    }

    public AccountEntity(long accountId, long accountNumber, int balance, int limit) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountId = accountId;
        this.limit = limit;
    }

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    @Column
    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Column
    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public AccountAndCardStatus getStatus() {
        return status;
    }

    public void setStatus(AccountAndCardStatus status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn (name = "authUserId")
    public AuthUserEntity getAuthUserEntity() {
        return authUserEntity;
    }

    public void setAuthUserEntity(AuthUserEntity authUserEntity) {
        this.authUserEntity = authUserEntity;
    }

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "accountId", cascade = CascadeType.ALL)
    public List<CardEntity> getCardEntities() {
        return cardEntities;
    }

    public void setCardEntities(List<CardEntity> cardEntities) {
        this.cardEntities = cardEntities;
    }

    @OneToMany(mappedBy = "toAccountEntity")
    public List<TransferEntity> getAcceptedTransferEntities() {
        return acceptedTransferEntities;
    }

    public void setAcceptedTransferEntities(List<TransferEntity> acceptedTransferEntities) {
        this.acceptedTransferEntities = acceptedTransferEntities;
    }

    @OneToMany(mappedBy = "fromAccountEntity")
    public List<TransferEntity> getSentTransferEntities() {
        return sentTransferEntities;
    }

    public void setSentTransferEntities(List<TransferEntity> sentTransferEntities) {
        this.sentTransferEntities = sentTransferEntities;
    }

}
