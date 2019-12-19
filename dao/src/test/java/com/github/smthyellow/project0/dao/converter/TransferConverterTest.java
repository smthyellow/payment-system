package com.github.smthyellow.project0.dao.converter;

import com.github.smthyellow.project0.dao.entity.TransferEntity;
import com.github.smthyellow.project0.model.Transfer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferConverterTest {
    @Test
    void fromEntityNull() {
        final Transfer transfer = TransferConverter.fromEntity(null);
        assertNull(transfer);
    }

    /*@Test
    void fromEntityNotNull() {
        final TransferEntity transferEntity = new TransferEntity();
        transferEntity.setTransferId(1L);
        transferEntity.setFromAccountId(2L);
        transferEntity.setToAccountId(3L);
        transferEntity.setSum(4);

        final Transfer transfer = TransferConverter.fromEntity(transferEntity);

        assertNotNull(transfer);
        assertEquals(transfer.getTransferId(), transferEntity.getTransferId());
        assertEquals(transfer.getFromAccountId(), transferEntity.getFromAccountId());
        assertEquals(transfer.getToAccountId(), transferEntity.getToAccountId());
        assertEquals(transfer.getSum(), transferEntity.getSum());
    }*/

//    private Long transferId;
//    private Long fromAccountId;
//    private Long toAccountId;
//    private int sum;
    @Test
    void toEntityNull() {
        final TransferEntity transferEntity = TransferConverter.toEntity(null);
        assertNull(transferEntity);
    }

    /*@Test
    void toEntityNotNull() {
        final Transfer transfer = new Transfer(1L, 2L, 3L, 4);

        final TransferEntity transferEntity = TransferConverter.toEntity(transfer);

        assertNotNull(transfer);
        assertEquals(transfer.getTransferId(), transferEntity.getTransferId());
        assertEquals(transfer.getFromAccountId(), transferEntity.getFromAccountId());
        assertEquals(transfer.getToAccountId(), transferEntity.getToAccountId());
        assertEquals(transfer.getSum(), transferEntity.getSum());
    }*/

}