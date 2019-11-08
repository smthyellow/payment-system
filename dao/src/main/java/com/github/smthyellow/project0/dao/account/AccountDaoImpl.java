package com.github.smthyellow.project0.dao.account;

import com.github.smthyellow.project0.dao.part.converter.AccountConverter;
import com.github.smthyellow.project0.dao.util.HibernateUtil;
import com.github.smthyellow.project0.dao.part.entity.AccountEntity;
import com.github.smthyellow.project0.model.Account;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.RollbackException;
import java.util.List;
import java.util.stream.Collectors;

public class AccountDaoImpl implements AccountDao{
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
    public List<Account> getAccountByUserId(long authUserId){
        Query<AccountEntity> query = HibernateUtil.getSession()
                .createQuery("from CardEntity au where au.authUserId = :authUserId")
                .setParameter("authUserId", authUserId)
                .setFirstResult()
                .setMaxResults();
        List<AccountEntity> cardEntityList = query.list();
        List<Account> accountList =
                cardEntityList.stream().
                map(AccountConverter::fromEntity).
                collect(Collectors.toList());

        return accountList;
    }

    @Override
    public long saveAccount(long authUserId, long accountNumber, int balance){
        AccountEntity accountEntity = new AccountEntity(authUserId, accountNumber, balance);
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(accountEntity);
        session.getTransaction().commit();

        return accountEntity.getAccountId();
    }

    @Override
    public Account getAccountByAccountId(long accountId){
        AccountEntity accountEntity = (AccountEntity) HibernateUtil.getSession()
                .createQuery("from AccountEntity au where au.accountId = :accountId")
                .setParameter("accountId", accountId).getSingleResult();

        return AccountConverter.fromEntity(accountEntity);
    }
}