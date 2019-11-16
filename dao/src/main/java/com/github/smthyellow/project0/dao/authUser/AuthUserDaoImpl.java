package com.github.smthyellow.project0.dao.authUser;

import com.github.smthyellow.project0.dao.util.HibernateUtil;
import com.github.smthyellow.project0.dao.util.part.converter.AuthUserConverter;
import com.github.smthyellow.project0.dao.util.part.converter.UserConverter;
import com.github.smthyellow.project0.dao.util.part.entity.AuthUserEntity;
import com.github.smthyellow.project0.dao.user.UserDao;
import com.github.smthyellow.project0.dao.user.UserDaoImpl;
import com.github.smthyellow.project0.dao.util.part.entity.UserEntity;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AuthUserDaoImpl implements AuthUserDao {

    public static class Singleton {
        static AuthUserDao HOLDER_INSTANCE = new AuthUserDaoImpl();
    }

    public static AuthUserDao getInstance() {
        return AuthUserDaoImpl.Singleton.HOLDER_INSTANCE;
    }

    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public AuthUser getByEmail(String email) {

        EntityManager em = HibernateUtil.getEm();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AuthUserEntity> criteria = cb.createQuery(AuthUserEntity.class);
        Root<AuthUserEntity> auth = criteria.from(AuthUserEntity.class);
        criteria.select(auth)
                .where(cb.equal(auth.get("email"), email));
        AuthUserEntity authUserEntity = em.createQuery(criteria).getSingleResult();


//        AuthUserEntity authUserEntity;
//        try {
//            authUserEntity = (AuthUserEntity) HibernateUtil.getSession()
//                    .createQuery("FROM AuthUserEntity A WHERE A.email = :paramEmail")
//                    .setParameter("paramEmail", email).getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        }
//
        return AuthUserConverter.fromEntity(authUserEntity);
    }

    @Override
    public AuthUser getByAuthUserId(long authUserId) {

        AuthUserEntity authUserEntity;
        try {
            authUserEntity = (AuthUserEntity) HibernateUtil.getSession()
                    .createQuery("FROM AuthUserEntity A WHERE A.authUserId = :authUserId")
                    .setParameter("authUserId", authUserId).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

        return AuthUserConverter.fromEntity(authUserEntity);
    }

    @Override
    public AuthUser saveAuthUser(AuthUser authUser, User user){
        AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);
        UserEntity userEntity = UserConverter.toEntity(user);
        final Session session = HibernateUtil.getSession();

        session.beginTransaction();
        authUserEntity.setUserEntity(userEntity);
        userEntity.setAuthUserEntity(authUserEntity);
        session.save(authUserEntity);
        session.getTransaction().commit();
        return authUser;
    }

    @Override
    public void updateAuthUser(AuthUser authUser, User user) {
        AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);
        UserEntity userEntity = UserConverter.toEntity(user);
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        authUserEntity.setUserEntity(userEntity);
        userEntity.setAuthUserEntity(authUserEntity);
        session.update(authUserEntity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteAuthUser(AuthUser authUser){
        AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(authUserEntity);
        session.getTransaction().commit();
    }

}
