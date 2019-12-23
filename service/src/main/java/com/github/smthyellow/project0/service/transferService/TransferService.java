package com.github.smthyellow.project0.service.transferService;

import com.github.smthyellow.project0.model.Transfer;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferService {
    void makeTransfer(Long fromAccountId, Long toAccountId, int sum);
    /*
    List<Transfer> getTransfersToUser(long authUserId);
    List<Transfer> getTransfersFromUser(long authUserId);

     */
}