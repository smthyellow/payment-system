package com.github.smthyellow.project0.dao.converter;

import com.github.smthyellow.project0.dao.entity.TransferEntity;
import com.github.smthyellow.project0.model.Transfer;

import java.time.LocalDateTime;

public class TransferConverter {
    public static TransferEntity toEntity(Transfer transfer){
        if(transfer == null){
            return null;
        }

        final TransferEntity transferEntity = new TransferEntity();

        transferEntity.setTransferId(transfer.getTransferId());
        transferEntity.setSum(transfer.getSum());
        return transferEntity;
    }

    public static Transfer fromEntity(TransferEntity transferEntity){
        if(transferEntity == null){
            return null;
        }
        return new Transfer(transferEntity.getTransferId(),
        transferEntity.getFromAccountId(),
        transferEntity.getToAccountId(),
        transferEntity.getSum(),
        transferEntity.getDate()

        /*private long transferId;
        private long fromCardId;
        private long toCardId;
        private int sum;
        private LocalDateTime date;

         */
        );
    }
}
