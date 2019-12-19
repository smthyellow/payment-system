package com.github.smthyellow.project0.dao.entity;

import com.github.smthyellow.project0.model.AccountAndCardStatus;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CardEntity {

    private long cardId;
    private long authUserId;
    private int cvv;
    private long cardNumber;
    private long accountId;
    private LocalDate expiryDate;
    private AccountAndCardStatus cardStatus;
    private AccountEntity accountEntity;

    public CardEntity() {
    }

    public CardEntity(long authUserId, int cvv, long cardNumber, long accountId,
                      LocalDate expiryDate, AccountAndCardStatus cardStatus) {
        this.authUserId = authUserId;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.accountId = accountId;
        this.expiryDate = expiryDate;
        this.cardStatus = cardStatus;
    }

    public CardEntity(long cardId, long authUserId, int cvv, long cardNumber, long accountId,
                      LocalDate expiryDate, AccountAndCardStatus cardStatus) {
        this.cardId = cardId;
        this.authUserId = authUserId;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.accountId = accountId;
        this.expiryDate = expiryDate;
        this.cardStatus = cardStatus;
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

    @Column (updatable = false)
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

    @Column(updatable = false)
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public AccountAndCardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(AccountAndCardStatus cardStatus) {
        this.cardStatus = cardStatus;
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
