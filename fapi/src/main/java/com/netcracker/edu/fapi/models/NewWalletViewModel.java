package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewWalletViewModel {

    private int balance;
    private int statusWalletId;

    public NewWalletViewModel() {
    }

    public NewWalletViewModel(int balance, int statusWalletId) {
        this.balance = balance;
        this.statusWalletId = statusWalletId;
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
