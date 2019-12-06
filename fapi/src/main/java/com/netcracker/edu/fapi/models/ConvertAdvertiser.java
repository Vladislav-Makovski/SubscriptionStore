package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConvertAdvertiser {
    private int id;
    private String name;
    private int walletId;
    private int userDetailsId;
    private int balance;

    public ConvertAdvertiser() {
    }

    public ConvertAdvertiser(int id, String name, int walletId, int userDetailsId, int balance) {
        this.id = id;
        this.name = name;
        this.walletId = walletId;
        this.userDetailsId = userDetailsId;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public int getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(int userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
