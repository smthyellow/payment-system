package com.github.smthyellow.project0.service.transferService;

import com.github.smthyellow.project0.dao.dao.transfer.TransferDao;
import com.github.smthyellow.project0.dao.dao.transfer.TransferDaoImpl;
import com.github.smthyellow.project0.model.Transfer;

import java.time.LocalDateTime;
import java.util.List;

public class TransferServiceImpl implements TransferService {
    private static class SingletonHolder {
        static final TransferService HOLDER_INSTANCE = new TransferServiceImpl();
    }
    public static TransferService getInstance() {
        return TransferServiceImpl.SingletonHolder.HOLDER_INSTANCE;
    }

    private TransferDao transferDao = TransferDaoImpl.getInstance();

    /*@Override
    public void newTransfer(long fromAccountId, long toAccountId, int sum, LocalDateTime date){
        Transfer transfer = new Transfer(fromAccountId, toAccountId, sum, date);
        transferDao.newTransfer(transfer);
    }

    public List<Transfer> getTransfersToUser(long authUserId){
        return transferDao.getTransfersToUser(authUserId);
    }

    public List<Transfer> getTransfersFromUser(long authUserId){
        return transferDao.getTransfersFromUser(authUserId);
    }

     */
}
