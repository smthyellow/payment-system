package com.github.smthyellow.project0.model;

public class Card {
    private Long cardId;
    private int userId;
    private short cvv;
    private int accountId;

    public Card(Long cardId, int userId, short cvv, int accountId) {
        this.cardId = cardId;
        this.userId = userId;
        this.cvv = cvv;
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
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
}
