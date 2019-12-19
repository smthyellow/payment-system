package com.github.smthyellow.project0.model;

public class Account {
    private long accountId;
    private long accountNumber;
    private int balance;
    private int limit;
    private AccountAndCardStatus status;

    public Account() {
    }

    public Account(long accountNumber, int balance, int limit, AccountAndCardStatus status) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.limit = limit;
        this.status = status;
    }

    public Account(long accountId, long accountNumber, int balance, int limit, AccountAndCardStatus status) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.limit = limit;
        this.status = status;
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

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
