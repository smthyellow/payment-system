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
/*
    @Override
    public long addAccount(AuthUser authUser){
        long accountNumber = (long) Math.round((Math.random() * 9999999999L) +1000000000L);

        Account account = new Account();
        account.setAccountId();
        long accountId = accountDao.saveAccount(Account account);
        return accountNumber;
    }

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
