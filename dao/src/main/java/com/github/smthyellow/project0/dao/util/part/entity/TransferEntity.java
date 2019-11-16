package com.github.smthyellow.project0.dao.util.part.entity;

import javax.persistence.*;

@Entity
@Table
public class TransferEntity {
    private long transferId;
    private long fromCardId;
    private long toCardId;
    private int sum;
    private AccountEntity toAccountEntity;
    private AccountEntity fromAccountEntity;

    public TransferEntity() {
    }

    public TransferEntity(Long fromAccountId, Long toAccountId, int sum) {
        this.sum = sum;
    }

    public TransferEntity(Long transferId, Long fromAccountId, Long toAccountId, int sum) {
        this.transferId = transferId;
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
    public long getFromCardId() {
        return fromCardId;
    }

    public void setFromCardId(long fromCardId) {
        this.fromCardId = fromCardId;
    }

    @Column
    public long getToCardId() {
        return toCardId;
    }

    public void setToCardId(long toCardId) {
        this.toCardId = toCardId;
    }

    @Column
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


    @ManyToOne
    @JoinColumn(name = "toAccountId")
    public AccountEntity getToAccountEntity() {
        return toAccountEntity;
    }

    public void setToAccountEntity(AccountEntity toAccountEntity) {
        this.toAccountEntity = toAccountEntity;
    }


    @ManyToOne
    @JoinColumn(name = "fromAccountId")
    public AccountEntity getFromAccountEntity() {
        return fromAccountEntity;
    }

    public void setFromAccountEntity(AccountEntity fromAccountEntity) {
        this.fromAccountEntity = fromAccountEntity;
    }
}
