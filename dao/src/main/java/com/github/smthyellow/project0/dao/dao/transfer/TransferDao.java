package com.github.smthyellow.project0.dao.dao.transfer;

import com.github.smthyellow.project0.model.Transfer;

import java.util.List;

public interface TransferDao {
    void addTransfer(Long fromAccount, Long toAccount, int sum);

    List<Transfer> getByFromAccount(Long fromAccountId);

    List<Transfer> getByToAccount(Long toAccountId);

    List<Transfer> getByToAuthUser(Long authUserId);

    List<Transfer> getByFromAuthUser(Long authUserId);

    //List<Transfer> getTransfersToUser(long authUserId);

    //List<Transfer> getTransfersFromUser(long authUserId);
}
