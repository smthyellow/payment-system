package com.github.smthyellow.project0.dao.converter;

import com.github.smthyellow.project0.dao.entity.AccountEntity;
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
    void toEntityNull() {
        final AccountEntity accountEntity = AccountConverter.toEntity(null);
        assertNull(accountEntity);
    }

}