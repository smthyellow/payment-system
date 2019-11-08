package com.github.smthyellow.project0.dao.part.converter;

import com.github.smthyellow.project0.dao.part.entity.BillEntity;
import com.github.smthyellow.project0.model.Bill;

import java.util.ArrayList;
import java.util.List;

public class BillConverter {
    public static BillEntity toEntity(Bill bill){
        if (bill == null){
            return null;
        }

        final BillEntity billEntity = new BillEntity();

        billEntity.setBillId(bill.getBillId());
        billEntity.setAmount(bill.getAmount());
        billEntity.setPaid(bill.isPaid());

        return billEntity;
    }

    public static Bill fromEntity(BillEntity billEntity){
        if (billEntity == null){
            return null;
        }

        return new Bill(
                billEntity.getBillId(),
                billEntity.getAmount(),
                billEntity.isPaid()
        );
    }
}
