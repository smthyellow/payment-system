package com.github.smthyellow.project0.service.accountService;

import com.github.smthyellow.project0.dao.account.AccountDao;
import com.github.smthyellow.project0.dao.account.AccountDaoImpl;
import com.github.smthyellow.project0.model.Account;

public class AccountServiceImpl implements AccountService{
    private static class SingletonHolder {
        static final AccountService HOLDER_INSTANCE = new AccountServiceImpl();
    }
    public static AccountService getInstance() {
        return AccountServiceImpl.SingletonHolder.HOLDER_INSTANCE;
    }

    private AccountDao accountDao = AccountDaoImpl.getInstance();

    @Override
    public long addAccount(long authUserId){
        long accountNumber = (long) Math.round((Math.random() * 9999999999L) +1000000000L);
        long accountId = accountDao.saveAccount(authUserId, accountNumber, 0);
        return accountNumber;
    }

    @Override
    public Account getAccountByAccountId(long accountId){
        Account card = accountDao.getAccountByAccountId(accountId);
        return card;
    }
}
