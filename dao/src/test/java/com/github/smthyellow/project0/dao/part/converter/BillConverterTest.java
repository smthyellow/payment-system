package com.github.smthyellow.project0.dao.part.converter;

import com.github.smthyellow.project0.dao.part.entity.AuthUserEntity;
import com.github.smthyellow.project0.dao.part.entity.BillEntity;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Bill;
import com.github.smthyellow.project0.model.Role;
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
        billEntity.setPaid(true);

        final Bill bill = BillConverter.fromEntity(billEntity);

        assertNotNull(bill);
        assertEquals(bill.getBillId(), billEntity.getBillId());
        assertEquals(bill.getAmount(), billEntity.getAmount());
        assertEquals(bill.isPaid(), billEntity.isPaid());
    }

    @Test
    void toEntityNull() {
        final BillEntity billEntity = BillConverter.toEntity(null);
        assertNull(billEntity);
    }

    @Test
    void toEntityNotNull() {
        final Bill bill = new Bill(1, 2L, false);

        final BillEntity billEntity = BillConverter.toEntity(bill);

        assertNotNull(bill);
        assertEquals(bill.getBillId(), billEntity.getBillId());
        assertEquals(bill.getAmount(), billEntity.getAmount());
        assertEquals(bill.isPaid(), billEntity.isPaid());
    }

}