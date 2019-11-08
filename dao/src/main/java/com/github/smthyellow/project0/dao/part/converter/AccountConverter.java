package com.github.smthyellow.project0.dao.part.converter;

import com.github.smthyellow.project0.dao.part.entity.AccountEntity;
import com.github.smthyellow.project0.model.Account;

public class AccountConverter {
    public static AccountEntity toEntity(Account account){
        if(account == null){
            return null;
        }

        final AccountEntity accountEntity = new AccountEntity();
        //long accountId, int userId, int balance
        accountEntity.setAccountId(account.getAccountId());
        accountEntity.setAuthUserId(account.getAuthUserId());
        accountEntity.setBalance(account.getBalance());

        return accountEntity;
    }

    public static Account fromEntity(AccountEntity accountEntity){
        if(accountEntity == null){
            return null;
        }

        return new Account(
                accountEntity.getAccountId(),
                accountEntity.getAuthUserId(),
                accountEntity.getBalance()
        );
    }

}