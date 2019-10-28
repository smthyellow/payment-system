package com.github.smthyellow.project0.model;

import java.util.Date;

public class Card {
    private Long id;
    private User owner;
    private Date expiryDate;
    private int cvv;
    private Account account;
    private long cardNumber;

    public Card(Long id, User owner, Date expiryDate, int cvv, Account account, long cardNumber) {
        this.id = id;
        this.owner = owner;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.account = account;
        this.cardNumber = cardNumber;
    }

    //public Card(int id, User owner, Date expiryDate, int cvv, Account account, long cardNumber){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }
}
