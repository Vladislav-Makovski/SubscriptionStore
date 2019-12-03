package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationCustomerViewModel {
    String username;
    String password;
    String email;
    int userRoleId;
    String firstName;
    String surname;
    int balance;
    int statusWalletId;

    public RegistrationCustomerViewModel() {
    }

    public RegistrationCustomerViewModel(String username, String password, String email, int userRoleId, String firstName, String surname, int balance, int statusWalletId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRoleId = userRoleId;
        this.firstName = firstName;
        this.surname = surname;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
