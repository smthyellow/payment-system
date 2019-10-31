package com.github.smthyellow.project0.dao.entity;
import com.github.smthyellow.project0.model.Role;
import com.github.smthyellow.project0.model.User;

import javax.persistence.*;

@Entity
@Table
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    @Enumerated (EnumType.STRING)
    private Role role;

    public UserEntity(String firstName, String lastName, String phone, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserEntity(int userId, String firstName, String lastName, String phone, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static UserEntity getUserEntity(User user){
        UserEntity userEntity = new UserEntity(user.getUserId(), user.getFirstName(), user.getLastName(),
                user.getPhone(), user.getEmail(), user.getPassword(), user.getRole());
        return userEntity;
    }
}
