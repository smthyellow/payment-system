package com.github.smthyellow.project0.model;

public class Account {
    private long accountId;
    private long accountNumber;
    private long authUserId;
    private int balance;

    public Account(long authUserId, long accountNumber, int balance) {
        this.authUserId = authUserId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account(long accountId, long authUserId, long accountNumber, int balance) {
        this.authUserId = authUserId;
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(long authUserId) {
        this.authUserId = authUserId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
