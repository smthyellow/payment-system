package com.github.smthyellow.project0.dao.util.part.entity;

import com.github.smthyellow.project0.model.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class AuthUserEntity {
    private long authUserId;
    private String email;
    private String password;
    private Role role;
    private UserEntity userEntity;
    private List<AccountEntity> accountEntities = new ArrayList<>();
    private List<BillEntity> billEntities = new ArrayList<>();


    public AuthUserEntity() {
    }

    public AuthUserEntity(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public AuthUserEntity(long authUserId, String email, String password, Role role) {
        this.authUserId = authUserId;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(long authUserId) {
        this.authUserId = authUserId;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @OneToOne(mappedBy = "authUserEntity", fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.ALL})
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @OneToMany (mappedBy = "authUserEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<AccountEntity> getAccountEntities() {
        return accountEntities;
    }

    public void setAccountEntities(List<AccountEntity> accountEntities) {
        this.accountEntities = accountEntities;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "AuthUserEntity_BillEntity", joinColumns = {@JoinColumn(name = "authUserId")},
            inverseJoinColumns = {@JoinColumn(name = "billId")}
    )
    public List<BillEntity> getBillEntities() {
        return billEntities;
    }

    public void setBillEntities(List<BillEntity> billEntities) {
        this.billEntities = billEntities;
    }
}
