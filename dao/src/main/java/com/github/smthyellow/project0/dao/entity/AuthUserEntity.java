package com.github.smthyellow.project0.dao.entity;

import com.github.smthyellow.project0.model.Role;
import com.github.smthyellow.project0.model.UserStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class AuthUserEntity {
    private long authUserId;
    private String email;
    private String password;
    private Role role;
    private UserEntity userEntity;
    private UserStatus status;
    private List<AccountEntity> accountEntities = new ArrayList<>();
    private List<OfferEntity> offerEntities = new ArrayList<>();


    public AuthUserEntity() {
    }

    public AuthUserEntity(String email, String password, Role role, UserStatus status) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public AuthUserEntity(long authUserId, String email, String password, Role role, UserStatus status) {
        this.authUserId = authUserId;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
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

    @Column
    @Enumerated(EnumType.STRING)
    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
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
    @JoinTable(name = "AuthUserEntity_OfferEntity", joinColumns = {@JoinColumn(name = "authUserId")},
            inverseJoinColumns = {@JoinColumn(name = "offerId")}
    )
    public List<OfferEntity> getOfferEntities() {
        return offerEntities;
    }

    public void setOfferEntities(List<OfferEntity> offerEntities) {
        this.offerEntities = offerEntities;
    }
}
