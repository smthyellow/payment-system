package com.github.smthyellow.project0.model;

public class User {
    private long userId;
    private String firstName;
    private String lastName;
    private String phone;
    private long authUserId;

    public User(long userId, String firstName, String lastName, String phone, long authUserId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.userId = userId;
        this.authUserId = authUserId;

    }

    public User(String firstName, String lastName, String phone, long authUserId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.authUserId = authUserId;
    }

    public User(String firstName, String lastName, String phone) {
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

    public long getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(long authUserId) {
        this.authUserId = authUserId;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }


}
