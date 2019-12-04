package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationAdvertiserViewModel {

    String username;
    String password;
    String email;
    int userRoleId;
    String name;
    int balance;
    int statusWalletId;

    public RegistrationAdvertiserViewModel() {
    }

    public RegistrationAdvertiserViewModel(String username, String password, String email, int userRoleId, String name, int balance, int statusWalletId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRoleId = userRoleId;
        this.name = name;
        this.balance = balance;
        this.statusWalletId = statusWalletId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getStatusWalletId() {
        return statusWalletId;
    }

    public void setStatusWalletId(int statusWalletId) {
        this.statusWalletId = statusWalletId;
    }
}
