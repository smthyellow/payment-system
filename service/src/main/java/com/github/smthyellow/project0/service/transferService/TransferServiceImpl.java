package com.github.smthyellow.project0.service.transferService;

import com.github.smthyellow.project0.dao.dao.account.AccountDao;
import com.github.smthyellow.project0.dao.dao.transfer.TransferDao;
import com.github.smthyellow.project0.dao.dao.transfer.TransferDaoImpl;
import com.github.smthyellow.project0.model.Transfer;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public class TransferServiceImpl implements TransferService {
    private final TransferDao transferDao;


    public TransferServiceImpl(TransferDao transferDao) {
        this.transferDao = transferDao;

    }

    @Override
    @Transactional
    public void makeTransfer(Long fromAccountId, Long toAccountId, int sum) {
        transferDao.addTransfer(fromAccountId, toAccountId, sum);
    }
}
