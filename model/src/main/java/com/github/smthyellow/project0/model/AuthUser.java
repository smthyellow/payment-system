package com.github.smthyellow.project0.model;

public class AuthUser {
    private long authUserId;
    private String email;
    private String password;
    private Role role;

    public AuthUser(long authUserId, String email, String password, Role role) {
        this.authUserId = authUserId;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public AuthUser(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public long getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(long authUserId) {
        this.authUserId = authUserId;
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

}
