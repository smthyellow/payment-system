package com.github.smthyellow.project0.service.accountService;

import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.model.AuthUser;

import java.util.List;

public interface AccountService {

    void addAccount(AuthUser authUser, int balance, int limit);

    int minusBalance(int sum, long accountId);
    /*

    void plusBalance(int sum, long accountId);



    Account getAccountByAccountId(long accountId);

     */

    //List<Account> getAccountsList(long authUserId);

    //List<Account> getPage(int page, long authUserId);
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
