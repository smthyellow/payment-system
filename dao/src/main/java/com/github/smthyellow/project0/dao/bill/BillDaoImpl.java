package com.github.smthyellow.project0.dao.bill;

import com.github.smthyellow.project0.dao.util.HibernateUtil;
import com.github.smthyellow.project0.dao.util.part.converter.AuthUserConverter;
import com.github.smthyellow.project0.dao.util.part.converter.BillConverter;
import com.github.smthyellow.project0.dao.util.part.entity.AuthUserEntity;
import com.github.smthyellow.project0.dao.util.part.entity.BillEntity;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Bill;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BillDaoImpl implements BillDao{

    public static class Singleton {
        static BillDao HOLDER_INSTANCE = new BillDaoImpl();
    }

    public static BillDao getInstance() {
        return BillDaoImpl.Singleton.HOLDER_INSTANCE;
    }

    /*@Override
    public void createBill(Bill bill){
        BillEntity billEntity = BillConverter.toEntity(bill);
        final Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(bill);
            session.getTransaction().commit();
        } catch (RollbackException e) {
            session.getTransaction().rollback();
        }
    }*/

    @Override
    public List<Bill> getAllBills(){
        EntityManager em = HibernateUtil.getEm();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<BillEntity> criteria = cb.createQuery(BillEntity.class);
        Root<BillEntity> billEntityRoot = criteria.from(BillEntity.class);
        criteria.select(billEntityRoot);
        List<BillEntity> listOfBills = em.createQuery(criteria).getResultList();

//        List<BillEntity> listOfBills = new ArrayList<>();
//        try {
//            BillEntity billEntity = (BillEntity) HibernateUtil.getSession()
//                    .createQuery("from BillEntity");
//        } catch (NoResultException e) {
//            return null;
//        }

        List <Bill> bills = listOfBills.stream().map(BillConverter::fromEntity).collect(Collectors.toList());
        return bills;
    }

    @Override
    public Bill getBillById(long billId){
        BillEntity billEntity = (BillEntity) HibernateUtil.getSession()
                .createQuery("from BillEntity be where be.billId = :billId")
                .setParameter("billId", billId).getSingleResult();

        return BillConverter.fromEntity(billEntity);
    }

    @Override
    public void appointBillToUser(Bill bill, AuthUser authUser){
        BillEntity billEntity = BillConverter.toEntity(bill);
        AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        billEntity.getAuthUserEntities().add(authUserEntity);
        authUserEntity.getBillEntities().add(billEntity);
        session.update(authUserEntity);
        session.getTransaction().commit();
    }

    //list.stream().map(BillConverter::fromEntity).forEach(listOfBills::add);
}
