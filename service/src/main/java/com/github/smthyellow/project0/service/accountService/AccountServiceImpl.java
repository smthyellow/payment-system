package com.github.smthyellow.project0.service.accountService;

import com.github.smthyellow.project0.dao.dao.account.AccountDao;
import com.github.smthyellow.project0.dao.dao.account.AccountDaoImpl;
import com.github.smthyellow.project0.dao.dao.authUser.AuthUserDao;
import com.github.smthyellow.project0.dao.dao.user.UserDao;
import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.model.AuthUser;

import java.util.List;

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

    @Override
    public Account getByAccountNumber(Long accountNumber) {
        return accountDao.getByAccountNumber(accountNumber);
    }

    @Override
    public List<Account> getByAuthUserIds(List<Long> authUserIds) {
        return accountDao.getByAuthUserIds(authUserIds);
    }

    @Override
    public List<Account> getAccountFinishedLimit() {
        return accountDao.getAccountFinishedLimit();
    }

    @Override
    public List<Account> getByAuthUserId(Long authUserid) {
        return accountDao.getByAuthUserId(authUserid);
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
