package com.github.smthyellow.project0.dao.util;

import com.github.smthyellow.project0.dao.dao.authUser.AuthUserDao;
import com.github.smthyellow.project0.dao.dao.authUser.AuthUserDaoImpl;
import com.github.smthyellow.project0.dao.dao.user.UserDao;
import com.github.smthyellow.project0.dao.dao.user.UserDaoImpl;
import com.github.smthyellow.project0.dao.repository.AuthUserRepository;
import com.github.smthyellow.project0.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(HibernateConfig.class)
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.github.smthyellow.project0.dao.repository")
public class DaoConfig {
    @Autowired
    private AuthUserRepository authUserRepository;
    @Autowired
    private UserRepository userRepository;

    @Bean
    public AuthUserDao authUserDao() {
        return new AuthUserDaoImpl(authUserRepository, userRepository);
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl(userRepository);
    }
}
