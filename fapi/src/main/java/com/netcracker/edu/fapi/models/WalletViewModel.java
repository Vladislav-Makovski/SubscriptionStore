package com.netcracker.edu.fapi.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletViewModel {

    private int id;
    private int balance;
    private int statusWalletId;

    public WalletViewModel() {
    }

    public WalletViewModel(int id, int balance, int statusWalletId) {
        this.id = id;
        this.balance = balance;
        this.statusWalletId = statusWalletId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int  balance) {
        this. balance =  balance;
    }

    public int getStatusWalletId() {
        return statusWalletId;
    }

    public void setStatusWalletId(int statusWalletId) {
        this.statusWalletId = statusWalletId;
    }
}
