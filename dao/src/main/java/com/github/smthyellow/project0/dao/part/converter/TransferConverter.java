package com.github.smthyellow.project0.dao.part.converter;

import com.github.smthyellow.project0.dao.part.entity.TransferEntity;
import com.github.smthyellow.project0.model.Transfer;

public class TransferConverter {
    public static TransferEntity toEntity(Transfer transfer){
        if(transfer == null){
            return null;
        }

        final TransferEntity transferEntity = new TransferEntity();

        transferEntity.setTransferId(transfer.getTransferId());
        transferEntity.setFromAccountId(transfer.getFromAccountId());
        transferEntity.setToAccountId(transfer.getToAccountId());
        transferEntity.setSum(transfer.getSum());

        return transferEntity;
    }

    public static Transfer fromEntity(TransferEntity transferEntity){
        if(transferEntity == null){
            return null;
        }

        return new Transfer(
                transferEntity.getTransferId(),
                transferEntity.getFromAccountId(),
                transferEntity.getToAccountId(),
                transferEntity.getSum()

        );
    }
}
