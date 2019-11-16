package com.github.smthyellow.project0.dao.account;

import com.github.smthyellow.project0.dao.util.part.converter.AccountConverter;
import com.github.smthyellow.project0.dao.util.HibernateUtil;
import com.github.smthyellow.project0.dao.util.part.converter.AuthUserConverter;
import com.github.smthyellow.project0.dao.util.part.entity.AccountEntity;
import com.github.smthyellow.project0.dao.util.part.entity.AuthUserEntity;
import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.model.AuthUser;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

public class AccountDaoImpl implements AccountDao {
    //private static final Logger log = LoggerFactory.getLogger(AccountDaoImpl.class);

    private static class SingletonHolder {
        static final AccountDao HOLDER_INSTANCE = new AccountDaoImpl();
    }

    public static AccountDao getInstance() {
        return AccountDaoImpl.SingletonHolder.HOLDER_INSTANCE;
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
    @Override
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
    public long saveAccount(AuthUser authUser, long accountNumber, int balance) {
        AccountEntity accountEntity = new AccountEntity(accountNumber, balance);
        AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);
        accountEntity.setAuthUserEntity(authUserEntity);
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        accountEntity.setAuthUserEntity(authUserEntity);
        authUserEntity.getAccountEntities().add(accountEntity);
        session.save(accountEntity);
        session.getTransaction().commit();

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
}