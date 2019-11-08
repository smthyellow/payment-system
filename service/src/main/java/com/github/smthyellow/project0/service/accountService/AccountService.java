package com.github.smthyellow.project0.service.accountService;

import com.github.smthyellow.project0.model.Account;

public interface AccountService {

    long addAccount(long authUserId);

    Account getAccountByAccountId(long accountId);
//
//    void plusBalance(Account account, int sum);
//
//    void minusBalance(Account account, int sum);
//
//    void blockAccount(Account account);
//
//    void unblockAccount(Account account);
//
//    void deleteAccount(Account account);

}
