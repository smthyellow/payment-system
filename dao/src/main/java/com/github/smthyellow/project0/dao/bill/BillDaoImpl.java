package com.github.smthyellow.project0.dao.bill;

import com.github.smthyellow.project0.dao.util.HibernateUtil;
import com.github.smthyellow.project0.dao.part.converter.BillConverter;
import com.github.smthyellow.project0.dao.part.entity.BillEntity;
import com.github.smthyellow.project0.model.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl implements BillDao{


//
//    public static class Singleton {
//        static BillDao HOLDER_INSTANCE = new BillDaoImpl();
//    }
//
//    public static BillDao getInstance() {
//        return BillDaoImpl.Singleton.HOLDER_INSTANCE;
//    }

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

/*    @Override
    public List<Bill> getBillByUserId(Long userId){
        List<Bill> listOfBills = new ArrayList<>();
        List<BillEntity> list;
        try {
            list = (List<BillEntity>) HibernateUtil.getSession()
                    .createQuery("from AuthUserEntity au where au.userId = :userId")
                    .setParameter("userId", userId);
        } catch (NoResultException e) {
            log.info("bills not found by userId{}",userId);
            return listOfBills;
        }
        list.stream().map(BillConverter::fromEntity).forEach(listOfBills::add);

        return listOfBills;
    }*/

    //list.stream().map(BillConverter::fromEntity).forEach(listOfBills::add);
}
