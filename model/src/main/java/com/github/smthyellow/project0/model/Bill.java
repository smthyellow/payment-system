package com.github.smthyellow.project0.model;

public class Bill {
    private int billId;
    private long amount;
    private boolean isPaid;

    public Bill(int billId, long amount, boolean isPaid) {
        this.billId = billId;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
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
