package com.github.smthyellow.project0.model;

public class Transfer {
    private long transferId;
    private long fromAccountId;
    private long toAccountId;
    private int sum;

    public Transfer() {
    }

    public Transfer(long fromAccountId, long toAccountId, int sum) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.sum = sum;
    }

    public Transfer(long transferId, long fromAccountId, long toAccountId, int sum) {
        this.transferId = transferId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.sum = sum;
    }

    public long getTransferId() {
        return transferId;
    }

    public void setTransferId(long transferId) {
        this.transferId = transferId;
    }

    public long getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public long getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(long toAccountId) {
        this.toAccountId = toAccountId;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
