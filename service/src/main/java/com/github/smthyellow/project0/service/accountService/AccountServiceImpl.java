package com.github.smthyellow.project0.service.accountService;

import com.github.smthyellow.project0.dao.dao.account.AccountDao;
import com.github.smthyellow.project0.dao.dao.account.AccountDaoImpl;
import com.github.smthyellow.project0.dao.dao.authUser.AuthUserDao;
import com.github.smthyellow.project0.dao.dao.user.UserDao;
import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.model.AuthUser;

import java.util.List;

/*
TODO: add account +
TODO: minus balance +
TODO: plus balance
TODO: change status
TODO: find by authUserId (list)
TODO: find by id
TODO: change limit
TODO: сравнить лимит и баланс
 */


public class AccountServiceImpl implements AccountService{
    private final AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void addAccount(AuthUser authUser, int balance, int limit){
        long accountNumber = (long) Math.round((Math.random() * 9999999999L) +1000000000L);
        accountDao.saveAccount(authUser, accountNumber, balance, limit);
    }

    @Override
    public int minusBalance(int sum, long accountId) {
        int balance = accountDao.minusBalance(accountId, sum);
        return balance;
    }

    /*

    @Override
    public Account getAccountByAccountId(long accountId){
        Account card = accountDao.getAccountByAccountId(accountId);
        return card;
    }

    public List<Account> getAccountsList(long authUserId){
        List<Account> accountsList = accountDao.getAccountsList(authUserId);
        return accountsList;
    }

    @Override
    public void plusBalance(int sum, long accountId){
        Account account = accountDao.getAccountByAccountId(accountId);
        account.setBalance(account.getBalance() + sum);
        accountDao.updateAccount(account);
    }

    @Override
    public void minusBalance(int sum, long accountId){
        Account account = accountDao.getAccountByAccountId(accountId);
        account.setBalance(account.getBalance() - sum);
        accountDao.updateAccount(account);
    }

    @Override
    public List<Account> getPage(int page, long authUserId) {
        return accountDao.getPage(page, authUserId);
    }

 */

}
