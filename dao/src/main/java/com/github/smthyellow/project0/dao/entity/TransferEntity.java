package com.github.smthyellow.project0.dao.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class TransferEntity {
    private long transferId;
    private long fromAccountId;
    private long toAccountId;
    private int sum;
    private LocalDateTime date;
    private AccountEntity toAccountEntity;
    private AccountEntity fromAccountEntity;

    public TransferEntity() {
    }

    public TransferEntity(Long fromAccountId, Long toAccountId, int sum, LocalDateTime date) {
        this.sum = sum;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.date = date;
    }

    public TransferEntity(Long transferId, Long fromAccountId, Long toAccountId, int sum, LocalDateTime date) {
        this.transferId = transferId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.sum = sum;
        this.date = date;

    }

    public TransferEntity(int sum, LocalDateTime date) {
        this.sum = sum;
        this.date = date;
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

    public void setToAccountId(long toCardId) {
        this.toAccountId = toCardId;
    }

    @Column
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Column
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    @ManyToOne
    @JoinColumn(name = "toAccountId", insertable=false, updatable=false)
    public AccountEntity getToAccountEntity() {
        return toAccountEntity;
    }

    public void setToAccountEntity(AccountEntity toAccountEntity) {
        this.toAccountEntity = toAccountEntity;
    }


    @ManyToOne
    @JoinColumn(name = "fromAccountId", insertable=false, updatable=false)
    public AccountEntity getFromAccountEntity() {
        return fromAccountEntity;
    }

    public void setFromAccountEntity(AccountEntity fromAccountEntity) {
        this.fromAccountEntity = fromAccountEntity;
    }
}
