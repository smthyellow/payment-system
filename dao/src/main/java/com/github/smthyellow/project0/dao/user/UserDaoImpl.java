package com.github.smthyellow.project0.dao.user;

import org.hibernate.Session;
import com.github.smthyellow.project0.dao.util.HibernateUtil;
import com.github.smthyellow.project0.dao.part.converter.UserConverter;
import com.github.smthyellow.project0.dao.part.entity.UserEntity;
import com.github.smthyellow.project0.model.User;

public class UserDaoImpl implements UserDao {

    public static class Singleton {
        static UserDao HOLDER_INSTANCE = new UserDaoImpl();
    }

    public static UserDao getInstance(){
        return UserDaoImpl.Singleton.HOLDER_INSTANCE;
    }

    @Override
    public void saveUser(User user) {
        UserEntity userEntity = UserConverter.toEntity(user);
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(userEntity);
        session.getTransaction().commit();
    }

    @Override
    public void deleteUser(User user) {
        UserEntity userEntity = UserConverter.toEntity(user);
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(userEntity);
        session.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
        UserEntity userEntity = UserConverter.toEntity(user);
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(userEntity);
        session.getTransaction().commit();
    }

    public User getUserById(Long id){
        UserEntity userEntity = (UserEntity) HibernateUtil.getSession()
                .createQuery("from UserEntity au where au.userId = :id")
                .setParameter("id", id)
                .getSingleResult();
        User user = UserConverter.fromEntity(userEntity);
        return user;
    }
}
