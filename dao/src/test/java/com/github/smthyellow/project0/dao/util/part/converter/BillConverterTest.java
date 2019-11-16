package com.github.smthyellow.project0.dao.util.part.converter;

import com.github.smthyellow.project0.dao.util.part.entity.BillEntity;
import com.github.smthyellow.project0.model.Bill;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillConverterTest {
    @Test
    void fromEntityNull() {
        final Bill bill = BillConverter.fromEntity(null);
        assertNull(bill);
    }

    @Test
    void fromEntityNotNull() {
        final BillEntity billEntity = new BillEntity();
        billEntity.setBillId(1);
        billEntity.setAmount(2);

        final Bill bill = BillConverter.fromEntity(billEntity);

        assertNotNull(bill);
        assertEquals(bill.getBillId(), billEntity.getBillId());
        assertEquals(bill.getAmount(), billEntity.getAmount());
    }

    @Test
    void toEntityNull() {
        final BillEntity billEntity = BillConverter.toEntity(null);
        assertNull(billEntity);
    }

    @Test
    void toEntityNotNull() {
        final Bill bill = new Bill(1, 2L);

        final BillEntity billEntity = BillConverter.toEntity(bill);

        assertNotNull(bill);
        assertEquals(bill.getBillId(), billEntity.getBillId());
        assertEquals(bill.getAmount(), billEntity.getAmount());
    }

}