package com.github.smthyellow.project0.dao.dao.user;

import com.github.smthyellow.project0.dao.converter.AuthUserConverter;
import com.github.smthyellow.project0.dao.repository.AuthUserRepository;
import com.github.smthyellow.project0.dao.repository.UserRepository;
import org.hibernate.Session;
import com.github.smthyellow.project0.dao.toDelete.HibernateUtil;
import com.github.smthyellow.project0.dao.converter.UserConverter;
import com.github.smthyellow.project0.dao.entity.UserEntity;
import com.github.smthyellow.project0.model.User;

import javax.persistence.NoResultException;

public class UserDaoImpl implements UserDao {
    private final UserRepository userRepository;

    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        UserEntity userEntity = UserConverter.toEntity(user);
        userRepository.save(userEntity);
    }

    @Override
    public User getByAuthUserId(long userId) {
        return  userRepository.findById(userId)
                .map(UserConverter::fromEntity)
                .orElse(null);
    }

    @Override
    public void updateUser(User user) {

    }

    /*
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

    public User getByAuthUserId(long id){
        UserEntity userEntity;
        try{
            userEntity = (UserEntity) HibernateUtil.getSession()
                    .createQuery("FROM UserEntity A WHERE A.authUserEntity.authUserId = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e){
            return null;
        }

        User user = UserConverter.fromEntity(userEntity);
        return user;
    }

 */
}
