package com.github.smthyellow.project0.service.transferService;

import com.github.smthyellow.project0.model.Transfer;

import java.util.List;

public interface TransferService {
    void newTransfer(long fromAccountId, long toAccountId, int sum);
    List<Transfer> getTransfersToUser(long authUserId);
    List<Transfer> getTransfersFromUser(long authUserId);
}