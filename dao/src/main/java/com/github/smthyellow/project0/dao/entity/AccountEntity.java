package com.github.smthyellow.project0.dao.entity;

import com.github.smthyellow.project0.model.Account;

import javax.persistence.*;

@Entity
@Table
public class AccountEntity {
    @Id
    @GeneratedValue
    private long accountId;
    @Column
    private int userId;
    @Column
    private int balance;

    public AccountEntity(int userId, int balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public AccountEntity(long accountId, int userId, int balance) {
        this.userId = userId;
        this.balance = balance;
        this.accountId = accountId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public static AccountEntity getAccountEntity(Account account){
        AccountEntity accountEntity = new AccountEntity(account.getAccountId(), account.getUserId(), account.getBalance());
        return accountEntity;
    }
}
