package com.github.smthyellow.project0.dao.authUser;

import com.github.smthyellow.project0.dao.util.HibernateUtil;
import com.github.smthyellow.project0.dao.part.converter.AuthUserConverter;
import com.github.smthyellow.project0.dao.part.entity.AuthUserEntity;
import com.github.smthyellow.project0.dao.user.UserDao;
import com.github.smthyellow.project0.dao.user.UserDaoImpl;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Role;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;

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
        AuthUserEntity authUserEntity;

        //EntityManager entityManager = HibernateUtil.getEm();
        //authUser = entityManager.find(AuthUser.class, email);

        /*EntityManager entityManager = HibernateUtil.getEm();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AuthUserEntity> criteria = criteriaBuilder.createQuery(AuthUserEntity.class);
        Root<AuthUserEntity> auth = criteria.from(AuthUserEntity.class);
        criteria.select(auth).where(criteriaBuilder.equal(auth.get("email"), email));
        List<AuthUserEntity> authUsers = entityManager.createQuery(criteria).getResultList();

        if (authUsers.size() == 0){
            return null;
        }

        authUserEntity = authUsers.get(0);
        return AuthUserConverter.toAuthUser(authUserEntity);*/

        try {
            authUserEntity = (AuthUserEntity) HibernateUtil.getSession()
                    .createQuery("from AuthUserEntity au where au.email = :email")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            authUserEntity = null;
        }
        return AuthUserConverter.fromEntity(authUserEntity);
    }

    @Override
    public long saveAuthUser(String email, String password, Role role){
        AuthUserEntity authUserEntity = new AuthUserEntity(email, password, role);
        final Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.save(authUserEntity);
        session.getTransaction().commit();

        return authUserEntity.getAuthUserId();
    }

    @Override
    public void updateAuthUser(AuthUser authUser) {
        AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);
        final Session session = HibernateUtil.getSession();

        session.beginTransaction();
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
