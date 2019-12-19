package com.github.smthyellow.project0.service;

import com.github.smthyellow.project0.dao.util.DaoConfig;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.authUserService.AuthUserServiceImpl;
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


}
