package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConverterStatusWallet {
    private int id;
    private int balance;
    private String status;

    public ConverterStatusWallet() {
    }

    public ConverterStatusWallet(int id, int balance, String statusWallet) {
        this.id = id;
        this.balance = balance;
        this.status = statusWallet;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String statusWallet) {
        this.status = statusWallet;
    }
}
