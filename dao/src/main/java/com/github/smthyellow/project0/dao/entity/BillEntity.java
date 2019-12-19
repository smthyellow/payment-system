package com.github.smthyellow.project0.dao.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class BillEntity {

    private long billId;
    private long amount;
    private List<AuthUserEntity> authUserEntities = new ArrayList<>();

    public BillEntity() {
    }

    public BillEntity(long amount) {
        this.amount = amount;
    }

    public BillEntity(int billId, long amount) {
        this.billId = billId;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    @Column
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @ManyToMany(mappedBy = "billEntities", cascade = CascadeType.ALL)
    public List<AuthUserEntity> getAuthUserEntities() {
        return authUserEntities;
    }

    public void setAuthUserEntities(List<AuthUserEntity> authUserEntities) {
        this.authUserEntities = authUserEntities;
    }
}
