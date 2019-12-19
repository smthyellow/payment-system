package com.github.smthyellow.project0.dao.entity;

import javax.persistence.*;

@Entity
@Table
public class UserEntity {

    private long userId;
    private String firstName;
    private String lastName;
    private String phone;
    private AuthUserEntity authUserEntity;

    public UserEntity() {
    }

    public UserEntity(String firstName, String lastName, String phone, AuthUserEntity authUserEntity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.authUserEntity = authUserEntity;
    }

    public UserEntity(long userId, String firstName, String lastName, String phone, AuthUserEntity authUserEntity) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.authUserEntity = authUserEntity;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authUserId")


    public AuthUserEntity getAuthUserEntity() {
        return authUserEntity;
    }

    public void setAuthUserEntity(AuthUserEntity authUserEntity) {
        this.authUserEntity = authUserEntity;
    }
}
