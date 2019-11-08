package com.github.smthyellow.project0.dao.account;

import com.github.smthyellow.project0.model.Account;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountDaoImplTest {
    private AccountDao dao = AccountDaoImpl.getInstance();

    @Test
    void getByUserId() {
        dao.saveAccount(2L, 3L, 4);
        final List<Account> accounts = dao.getAccountByUserId(1L);

        assertNotNull(accounts);

        for (Account a: accounts) {
            assertEquals(a.getAuthUserId(), 1L);
        }
    }

    @Test
    void getAccountByAccountId() {
        long accountId = dao.saveAccount(2L, 3L, 4);
        final Account account = dao.getAccountByAccountId(accountId);

        assertNotNull(account);

        assertEquals(account.getAuthUserId(), 1L);
        assertEquals(account.getAccountNumber(), 2L);
        assertEquals(account.getBalance(), 4);
    }


}