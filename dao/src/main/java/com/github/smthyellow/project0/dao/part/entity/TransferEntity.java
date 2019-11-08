package com.github.smthyellow.project0.dao.part.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TransferEntity {
    private Long transferId;
    private Long fromAccountId;
    private Long toAccountId;
    private int sum;

    public TransferEntity() {
    }

    public TransferEntity(Long fromAccountId, Long toAccountId, int sum) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.sum = sum;
    }

    public TransferEntity(Long transferId, Long fromAccountId, Long toAccountId, int sum) {
        this.transferId = transferId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.sum = sum;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getTransferId() {
        return transferId;
    }

    public void setTransferId(long transferId) {
        this.transferId = transferId;
    }

    @Column
    public long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    @Column
    public long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(long toAccountId) {
        this.toAccountId = toAccountId;
    }

    @Column
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
