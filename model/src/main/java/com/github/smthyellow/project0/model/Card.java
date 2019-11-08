package com.github.smthyellow.project0.model;

public class Card {
    private long cardId;
    private long userId;
    private int cvv;
    private long cardNumber;
    private long accountId;

    public Card(long userId, int cvv, long cardNumber, long accountId) {
        this.userId = userId;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.accountId = accountId;
    }

    public Card(long cardId, long userId, int cvv, long cardNumber, long accountId) {
        this.cardId = cardId;
        this.userId = userId;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.accountId = accountId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
}
