package com.github.smthyellow.project0.dao.dao.account;

import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.model.AccountAndCardStatus;
import com.github.smthyellow.project0.model.AuthUser;

import java.util.List;

public interface AccountDao {
    void saveAccount(AuthUser authUser, Long accountNumber, int balance, int limit);

    Account getByAccountId(Long accountId);

    int minusBalance(Long accountId, int sum);

    int plusBalance(Long accountId, int sum);

    void changeStatus(Long accountId, AccountAndCardStatus status);

    List getByAuthUserId(Long authUserId);

    boolean compareBalanceWithLimit(Long accountId);

    void changeLimit(Long accountId, int limit);



    /*Account getAccountByAccountId(long accountId);

    void updateAccount(Account account);

    List<Account> getAccountsList(long authUserId, int page);

    List<Account> getPage(int page, long authUserId);*/

}
