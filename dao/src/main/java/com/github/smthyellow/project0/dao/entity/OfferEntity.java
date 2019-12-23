package com.github.smthyellow.project0.dao.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class OfferEntity {

    private String name;
    private long offerId;
    private long amount;
    private List<AuthUserEntity> authUserEntities = new ArrayList<>();

    public OfferEntity() {
    }

    public OfferEntity(String name, Long amount) {
        this.name = name;
        this.amount = amount;
    }

    public OfferEntity(String name, int offerId, Long amount) {
        this.name = name;
        this.offerId = offerId;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getOfferId() {
        return offerId;
    }

    public void setOfferId(long billId) {
        this.offerId = billId;
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

    @ManyToMany(mappedBy = "offerEntities", cascade = CascadeType.ALL)
    public List<AuthUserEntity> getAuthUserEntities() {
        return authUserEntities;
    }

    public void setAuthUserEntities(List<AuthUserEntity> authUserEntities) {
        this.authUserEntities = authUserEntities;
    }
}
