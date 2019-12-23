package com.github.smthyellow.project0.dao.util;

import com.github.smthyellow.project0.dao.dao.account.AccountDao;
import com.github.smthyellow.project0.dao.dao.account.AccountDaoImpl;
import com.github.smthyellow.project0.dao.dao.authUser.AuthUserDao;
import com.github.smthyellow.project0.dao.dao.authUser.AuthUserDaoImpl;
import com.github.smthyellow.project0.dao.dao.offer.OfferDao;
import com.github.smthyellow.project0.dao.dao.offer.OfferDaoImpl;
import com.github.smthyellow.project0.dao.dao.card.CardDao;
import com.github.smthyellow.project0.dao.dao.card.CardDaoImpl;
import com.github.smthyellow.project0.dao.dao.transfer.TransferDao;
import com.github.smthyellow.project0.dao.dao.transfer.TransferDaoImpl;
import com.github.smthyellow.project0.dao.dao.user.UserDao;
import com.github.smthyellow.project0.dao.dao.user.UserDaoImpl;
import com.github.smthyellow.project0.dao.repository.*;
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
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private OfferRepository offerRepository;

    @Bean
    public AuthUserDao authUserDao() {
        return new AuthUserDaoImpl(authUserRepository, userRepository);
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl(userRepository);
    }

    @Bean
    public AccountDao accountDao(){
        return new AccountDaoImpl(accountRepository, cardRepository);
    }

    @Bean
    public CardDao cardDao(){
        return  new CardDaoImpl(cardRepository, accountRepository);
    }

    @Bean
    public TransferDao transferDao() {
        return new TransferDaoImpl(transferRepository, accountRepository);
    }

    @Bean
    public OfferDao offerDao() {
        return new OfferDaoImpl(offerRepository, authUserRepository);
    }
}
