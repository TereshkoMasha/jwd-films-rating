package com.epam.entity;

import com.epam.entity.enums.UserRole;
import com.epam.entity.enums.UserStatus;

public class User extends AbstractBaseEntity {
    private String login;
    private String password;
    private String name;
    private UserRole role;
    private UserStatus userStatus;

    public User() {

    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}

