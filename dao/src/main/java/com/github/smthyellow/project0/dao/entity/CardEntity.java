package com.github.smthyellow.project0.dao.entity;

import com.github.smthyellow.project0.model.Card;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class CardEntity {
    @Id
    @GeneratedValue
    private Long cardId;
    @Column
    private int userId;
    @Column
    private short cvv;
    @Column
    private int accountId;

    public CardEntity(int userId, short cvv, int accountId) {
        this.userId = userId;
        this.cvv = cvv;
        this.accountId = accountId;
    }

    public CardEntity(Long cardId, int userId, short cvv, int accountId) {
        this.userId = userId;
        this.cvv = cvv;
        this.accountId = accountId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public short getCvv() {
        return cvv;
    }

    public void setCvv(short cvv) {
        this.cvv = cvv;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public static CardEntity getCardEntity(Card card){
        CardEntity cardEntity = new CardEntity(card.getCardId(), card.getUserId(), card.getCvv(), card.getAccountId());
        return cardEntity;
    }
}
