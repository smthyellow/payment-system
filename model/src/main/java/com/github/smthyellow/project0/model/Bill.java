package com.github.smthyellow.project0.model;

public class Bill {
    private int billId;
    private int userId;
    private long amount;
    private boolean isPaid;

    public Bill(int billId, int userId, long amount, boolean isPaid) {
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
}
