package com.github.smthyellow.project0.service.accountService;

import com.github.smthyellow.project0.dao.dao.account.AccountDao;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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