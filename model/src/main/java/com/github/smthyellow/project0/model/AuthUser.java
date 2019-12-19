package com.github.smthyellow.project0.model;

public class AuthUser {
    private Long authUserId;
    private String email;
    private String password;
    private Role role;
    private UserStatus status;

    public AuthUser() {
    }

    public AuthUser(Long authUserId, String email, String password, Role role, UserStatus status) {
        this.authUserId = authUserId;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public AuthUser(String email, String password, Role role, UserStatus status) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
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

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
