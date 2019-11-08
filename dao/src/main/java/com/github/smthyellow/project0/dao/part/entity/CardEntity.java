package com.github.smthyellow.project0.dao.part.entity;

import com.github.smthyellow.project0.model.Card;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class CardEntity {

    private long cardId;
    private long authUserId;
    private int cvv;
    private long cardNumber;
    private long accountId;

    public CardEntity() {
    }

    public CardEntity(long userId, int cvv, long cardNumber, long accountId) {
        this.authUserId = userId;
        this.cvv = cvv;
        this.accountId = accountId;
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


    private AuthUserEntity authUserEntity;

    private Set<BillEntity> billEntitySet;

    private AccountEntity accountEntity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "authUserId")
    public AuthUserEntity getAuthUserEntity() {
        return authUserEntity;
    }

    public void setAuthUserEntity(AuthUserEntity authUserEntity) {
        this.authUserEntity = authUserEntity;
    }

    @OneToMany(mappedBy = "cardEntity", cascade = CascadeType.ALL)
    public Set<BillEntity> getBillEntitySet() {
        return billEntitySet;
    }

    public void setBillEntitySet(Set<BillEntity> billEntitySet) {
        this.billEntitySet = billEntitySet;
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
