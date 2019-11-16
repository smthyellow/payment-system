package com.github.smthyellow.project0.dao.transfer;

import com.github.smthyellow.project0.dao.util.HibernateUtil;
import com.github.smthyellow.project0.dao.util.part.converter.TransferConverter;

import com.github.smthyellow.project0.dao.util.part.entity.TransferEntity;
import com.github.smthyellow.project0.model.Transfer;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class TransferDaoImpl implements TransferDao {
    public static class Singleton {
        static TransferDao HOLDER_INSTANCE = new TransferDaoImpl();
    }

    public static TransferDao getInstance() {
        return TransferDaoImpl.Singleton.HOLDER_INSTANCE;
    }

    @Override
    public void newTransfer(Transfer transfer){
        TransferEntity transferEntity = TransferConverter.toEntity(transfer);
        final Session session = HibernateUtil.getSession();

        session.beginTransaction();
        session.save(transferEntity);
        session.getTransaction().commit();
    }

    @Override
    public List<Transfer> getTransfersToUser(long toUser){
        Query<TransferEntity> query = HibernateUtil.getSession()
                .createQuery("from TransferEntity au where au.toUser = :toUser")
                .setParameter("toUser", toUser)
                .setFirstResult(0)
                .setMaxResults(10);
        List<TransferEntity> transferEntities = query.list();
        List<Transfer> transferList =
                transferEntities.stream().
                        map(TransferConverter::fromEntity).
                        collect(Collectors.toList());

        return transferList;
    }

    @Override
    public List<Transfer> getTransfersFromUser(long fromUser){
        Query<TransferEntity> query = HibernateUtil.getSession()
                .createQuery("from TransferEntity au where au.fromUser = :fromUser")
                .setParameter("fromUser", fromUser)
                .setFirstResult(0)
                .setMaxResults(10);
        List<TransferEntity> transferEntities = query.list();
        List<Transfer> transferList =
                transferEntities.stream().
                        map(TransferConverter::fromEntity).
                        collect(Collectors.toList());

        return transferList;
    }


}
