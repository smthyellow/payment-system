package com.github.smthyellow.project0.dao.entity;

import com.github.smthyellow.project0.model.Bill;

import javax.persistence.*;

@Entity
@Table
public class BillEntity {
    @Id
    @GeneratedValue
    private int billId;
    @Column
    private int userId;
    @Column
    private long amount;
    @Column
    private boolean isPaid;

    public BillEntity(int userId, long amount, boolean isPaid) {
        this.userId = userId;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public BillEntity(int billId, int userId, long amount, boolean isPaid) {
        this.billId = billId;
        this.userId = userId;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public static BillEntity getBillEntity(Bill bill){
        BillEntity billEntity = new BillEntity(bill.getBillId(), bill.getUserId(), bill.getAmount(), bill.isPaid());
        return billEntity;
    }
}
