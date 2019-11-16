package com.github.smthyellow.project0.dao.util.part.converter;

import com.github.smthyellow.project0.dao.util.part.entity.BillEntity;
import com.github.smthyellow.project0.model.Bill;

public class BillConverter {
    public static BillEntity toEntity(Bill bill){
        if (bill == null){
            return null;
        }

        final BillEntity billEntity = new BillEntity();

        billEntity.setBillId(bill.getBillId());
        billEntity.setAmount(bill.getAmount());
        return billEntity;
    }

    public static Bill fromEntity(BillEntity billEntity){
        if (billEntity == null){
            return null;
        }
        return new Bill(
                billEntity.getBillId(),
                billEntity.getAmount()
        );
    }
}
