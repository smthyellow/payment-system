package com.github.smthyellow.project0.dao.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class BillEntity {

    private String name;
    private long billId;
    private long amount;
    private List<AuthUserEntity> authUserEntities = new ArrayList<>();

    public BillEntity() {
    }

    public BillEntity(String name, Long amount) {
        this.name = name;
        this.amount = amount;
    }

    public BillEntity(String name, int billId, Long amount) {
        this.name = name;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
