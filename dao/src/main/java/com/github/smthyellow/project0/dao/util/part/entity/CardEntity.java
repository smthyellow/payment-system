package com.github.smthyellow.project0.dao.util.part.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
import javax.persistence.*;


@Entity
@Table
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CardEntity {

    private long cardId;
    private long authUserId;
    private int cvv;
    private long cardNumber;
    private long accountId;
    private AccountEntity accountEntity;

    public CardEntity() {
    }

    public CardEntity(int cvv, long cardNumber) {
        this.cvv = cvv;
        this.cardNumber = cardNumber;
    }

    public CardEntity(long cardId, long userId, int cvv, long cardNumber, long accountId) {
        this.authUserId = userId;
        this.cvv = cvv;
        this.accountId = accountId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    @Column(insertable = false, updatable = false)
    public long getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(long authUserId) {
        this.authUserId = authUserId;
    }

    @Column
    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    @Column
    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Column(updatable = false, insertable = false)
    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "accountId")
    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
}
