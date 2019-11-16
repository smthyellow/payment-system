package com.github.smthyellow.project0.service.accountService;

import com.github.smthyellow.project0.dao.account.AccountDao;
import com.github.smthyellow.project0.dao.authUser.AuthUserDao;
import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.service.authUserService.AuthUserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {
    @Mock
    AccountDao dao;

    @InjectMocks
    AccountServiceImpl service;

    /*@Test
    void addAccount(){
        when(dao.saveAccount(1L, 1111111111L, 0)).thenReturn(1L);

        long accountId = service.addAccount(1L);
        assertNotNull(accountId);


    }*/

}