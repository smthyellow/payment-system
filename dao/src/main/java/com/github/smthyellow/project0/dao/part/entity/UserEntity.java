package com.github.smthyellow.project0.dao.part.entity;
import com.github.smthyellow.project0.model.User;

import javax.persistence.*;

@Entity
@Table
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String phone;

    public UserEntity() {
    }

    public UserEntity(String firstName, String lastName, String phone, long authUserId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public UserEntity(long userId, String firstName, String lastName, String phone, long authUserId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn (name = "authUserId")
    private AuthUserEntity authUserEntity;

    public AuthUserEntity getAuthUserEntity() {
        return authUserEntity;
    }

    public void setAuthUserEntity(AuthUserEntity authUserEntity) {
        this.authUserEntity = authUserEntity;
    }
}
