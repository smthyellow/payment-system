package com.github.smthyellow.project0.model;

import java.time.LocalDateTime;

public class Transfer {
    private long transferId;
    private long fromAccountId;
    private long toAccountId;
    private int sum;
    private LocalDateTime date;

    public Transfer() {
    }

    public Transfer(long transferId, long fromAccountId, long toAccountId, int sum, LocalDateTime date) {
        this.transferId = transferId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.sum = sum;
        this.date = date;
    }

    public Transfer(long fromAccountId, long toAccountId, int sum, LocalDateTime date) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.sum = sum;
        this.date = date;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
