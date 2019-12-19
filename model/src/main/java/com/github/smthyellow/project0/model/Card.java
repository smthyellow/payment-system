package com.github.smthyellow.project0.model;

import java.time.LocalDate;

public class Card {
    private long cardId;
    private long userId;
    private int cvv;
    private long cardNumber;
    private long accountId;
    private LocalDate expiryDate;
    private AccountAndCardStatus cardStatus;

    public Card() {
    }

    public Card(long cardId, long userId, int cvv, long cardNumber, long accountId, LocalDate expiryDate, AccountAndCardStatus cardStatus) {
        this.cardId = cardId;
        this.userId = userId;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.accountId = accountId;
        this.expiryDate = expiryDate;
        this.cardStatus = cardStatus;
    }

    public Card(long userId, int cvv, long cardNumber, long accountId, LocalDate expiryDate, AccountAndCardStatus cardStatus) {
        this.userId = userId;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.accountId = accountId;
        this.expiryDate = expiryDate;
        this.cardStatus = cardStatus;
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

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}
