package com.github.smthyellow.project0.model;

public class Bill {
    private long billId;
    private long amount;

    public Bill(long billId, long amount) {
        this.billId = billId;
        this.amount = amount;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

}
