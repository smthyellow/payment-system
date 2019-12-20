package com.github.smthyellow.project0.dao.entity;

import com.github.smthyellow.project0.model.AccountAndCardStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class AccountEntity {

    private Long accountId;
    private Long accountNumber;
    private int balance;
    private int border;
    private AccountAndCardStatus status;
    private AuthUserEntity authUserEntity;
    private List<CardEntity> cardEntities = new ArrayList<>();
    private List<TransferEntity> acceptedTransferEntities = new ArrayList<>();
    private List<TransferEntity> sentTransferEntities = new ArrayList<>();

    public AccountEntity() {
    }

    public AccountEntity(Long accountNumber, int balance, int border, AccountAndCardStatus status) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.border = border;
    }

    public AccountEntity(Long accountId, Long accountNumber, int balance, int border, AccountAndCardStatus status) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountId = accountId;
        this.border = border;
    }

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    @Column
    public Long getAccountNumber() {
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
    public int getBorder() {
        return border;
    }

    public void setBorder(int limit) {
        this.border = limit;
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
