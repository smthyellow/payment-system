package com.github.smthyellow.project0.dao.part.entity;

import com.github.smthyellow.project0.model.Bill;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;
    @Column
    private long amount;
    @Column
    private boolean isPaid;

    public BillEntity() {
    }

    public BillEntity(long amount, boolean isPaid) {
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public BillEntity(int billId, long amount, boolean isPaid) {
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "cardId")
    private CardEntity cardEntity;
//
    @ManyToMany(mappedBy = "billEntities", cascade = CascadeType.ALL)
    private List<AuthUserEntity> authUserEntities = new ArrayList<>();

    public CardEntity getCardEntity() {
        return cardEntity;
    }

    public void setCardEntity(CardEntity cardEntity) {
        this.cardEntity = cardEntity;
    }

    public List<AuthUserEntity> getAuthUserEntities() {
        return authUserEntities;
    }

    public void setAuthUserEntities(List<AuthUserEntity> authUserEntities) {
        this.authUserEntities = authUserEntities;
    }


}
