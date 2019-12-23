package com.github.smthyellow.project0.dao.dao.account;

import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.model.AccountAndCardStatus;
import com.github.smthyellow.project0.model.AuthUser;

import java.util.List;

public interface AccountDao {
    List<Account> getAccountFinishedLimit();

    List<Account> getByAuthUserIds(List<Long> authUserIds);

    void saveAccount(AuthUser authUser, Long accountNumber, int balance, int limit);

    Account getByAccountNumber(Long accountNumber);

    Account getByAccountId(Long accountId);

    int minusBalance(Long accountId, int sum);

    int plusBalance(Long accountId, int sum);

    void changeStatus(Long accountId, AccountAndCardStatus status);

    List getByAuthUserId(Long authUserId);

    boolean compareBalanceWithBorder(Long accountId);

    void changeBorder(Long accountId, int border);

}
