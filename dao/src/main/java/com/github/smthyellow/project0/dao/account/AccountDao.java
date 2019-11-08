package com.github.smthyellow.project0.dao.account;

import com.github.smthyellow.project0.model.Account;

import java.util.List;

public interface AccountDao {
    long saveAccount(long authUserId, long accountNumber, int balance);

    Account getAccountByAccountId(long accountId);

    //boolean checkId(Long accountId);

    /*int plusAccountBalance();

    int minusAccountBalance();

    void blockAccount();

    void unblockAccount();

    void deactivateAccount();*/

    List<Account> getAccountByUserId(long authUserId);

}
