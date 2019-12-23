package com.github.smthyellow.project0.service;

import com.github.smthyellow.project0.dao.util.DaoConfig;
import com.github.smthyellow.project0.service.accountService.AccountService;
import com.github.smthyellow.project0.service.accountService.AccountServiceImpl;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.authUserService.AuthUserServiceImpl;
import com.github.smthyellow.project0.service.offerService.OfferService;
import com.github.smthyellow.project0.service.offerService.OfferServiceImpl;
import com.github.smthyellow.project0.service.cardService.CardService;
import com.github.smthyellow.project0.service.cardService.CardServiceImpl;
import com.github.smthyellow.project0.service.transferService.TransferService;
import com.github.smthyellow.project0.service.transferService.TransferServiceImpl;
import com.github.smthyellow.project0.service.userService.UserService;
import com.github.smthyellow.project0.service.userService.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    private DaoConfig daoConfig;

    public ServiceConfig(DaoConfig daoConfig) {
        this.daoConfig = daoConfig;
    }

    @Bean
    public AuthUserService authUserService(){
        return new AuthUserServiceImpl(daoConfig.authUserDao(), daoConfig.userDao());
    }

    @Bean
    public UserService userService(){
        return new UserServiceImpl(daoConfig.userDao());
    }

    @Bean
    public AccountService accountService(){
        return new AccountServiceImpl(daoConfig.accountDao());
    }

    @Bean
    public OfferService offerService(){
        return new OfferServiceImpl(daoConfig.offerDao());
    }

    @Bean
    public TransferService transferService(){
        return new TransferServiceImpl(daoConfig.transferDao());
    }

    @Bean
    public CardService cardService(){
        return new CardServiceImpl(daoConfig.cardDao());
    }


}
