package com.github.smthyellow.project0.model;

public class Offer {
    private long offerId;
    private long amount;

    public Offer(long offerId, long amount) {
        this.offerId = offerId;
        this.amount = amount;
    }

    public long getOfferId() {
        return offerId;
    }

    public void setOfferId(long offerId) {
        this.offerId = offerId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

}
