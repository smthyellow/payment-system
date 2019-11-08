package com.github.smthyellow.project0.dao.part.converter;

import com.github.smthyellow.project0.dao.part.entity.AccountEntity;
import com.github.smthyellow.project0.model.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountConverterTest {

    @Test
    void fromEntityNull() {
        final Account account = AccountConverter.fromEntity(null);
        assertNull(account);
    }

    @Test
    void fromEntityNotNull() {
        final AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountId(1L);
        accountEntity.setAuthUserId(2L);
        accountEntity.setBalance(3);

        final Account account = AccountConverter.fromEntity(accountEntity);

        assertNotNull(account);
        assertEquals(account.getAccountId(), accountEntity.getAccountId());
        assertEquals(account.getAuthUserId(), accountEntity.getAuthUserId());
        assertEquals(account.getBalance(), accountEntity.getBalance());
    }

    @Test
    void toEntityNull() {
        final AccountEntity accountEntity = AccountConverter.toEntity(null);
        assertNull(accountEntity);
    }

    @Test
    void toEntityNotNull() {
        final Account account = new Account(1L, 2L, 3);

        final AccountEntity authUserEntity = AccountConverter.toEntity(account);

        assertNotNull(account);
        assertEquals(account.getAccountId(), authUserEntity.getAuthUserId());
        assertEquals(account.getAuthUserId(), authUserEntity.getAuthUserId());
        assertEquals(account.getBalance(), authUserEntity.getBalance());
    }
}