package com.github.smthyellow.project0.dao.dao.account;

import com.github.smthyellow.project0.dao.converter.AccountConverter;
import com.github.smthyellow.project0.dao.converter.AuthUserConverter;
import com.github.smthyellow.project0.dao.converter.UserConverter;
import com.github.smthyellow.project0.dao.dao.authUser.AuthUserDaoImpl;
import com.github.smthyellow.project0.dao.entity.AccountEntity;
import com.github.smthyellow.project0.dao.entity.AuthUserEntity;
import com.github.smthyellow.project0.dao.entity.UserEntity;
import com.github.smthyellow.project0.dao.repository.AccountRepository;
import com.github.smthyellow.project0.dao.repository.AuthUserRepository;
import com.github.smthyellow.project0.dao.repository.UserRepository;
import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.model.AuthUser;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AccountDaoImpl implements AccountDao {

    private static final Logger log = LoggerFactory.getLogger(AccountDaoImpl.class);
    private final AccountRepository accountRepository;

    public AccountDaoImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /*@Override
    public boolean checkId(Long accountId){
        AccountEntity accountEntity;
        try {
            accountEntity = (AccountEntity) HibernateUtil.getSession()
                    .createQuery("from AuthUserEntity au where au.accountId = :accountId")
                    .setParameter("accountId", accountId)
                    .getSingleResult();
        } catch (NoResultException e) {
            accountEntity = null;
        }

        return accountEntity != null;
    }*/
    /*@Override
    public List<Account> getAccountsList(long authUserId, int page) {
        Query<AccountEntity> query = HibernateUtil.getSession()
                .createQuery("from AccountEntity au where au.authUserEntity.authUserId = :authUserId")
                .setParameter("authUserId", authUserId);
        List<AccountEntity> accountEntityList = query.list();
        List<Account> accountList =
                accountEntityList.stream()
                        .map(AccountConverter::fromEntity)
                        .collect(Collectors.toList());

        return accountList;
    }

    @Override
    public List<Account> getPage(int page, long authUserId) {
        int pageSize = 5;
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from AccountEntity au where au.authUserEntity.authUserId = :authUserId")
                .setParameter("authUserId", authUserId);

        List<AccountEntity> accountEntityList = query
                .setMaxResults(pageSize)
                .setFirstResult((page - 1) * pageSize)
                .getResultList();
        List<Account> accountList =
                accountEntityList.stream()
                        .map(AccountConverter::fromEntity)
                        .collect(Collectors.toList());
        return accountList;
    }

    @Override
    public long saveAccount(Account account) {
        accountRepository.save(authUserEntity);
        userRepository.save(userEntity);
        return accountEntity.getAccountId();

    }

    @Override
    public Account getAccountByAccountId(long accountId) {
        AccountEntity accountEntity = (AccountEntity) HibernateUtil.getSession()
                .createQuery("from AccountEntity au where au.accountId = :accountId")
                .setParameter("accountId", accountId).getSingleResult();

        return AccountConverter.fromEntity(accountEntity);
    }

    @Override
    public void updateAccount(Account account) {
        AccountEntity accountEntity = AccountConverter.toEntity(account);
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(accountEntity);
        session.getTransaction().commit();
    }

     */
}