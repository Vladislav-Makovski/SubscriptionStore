package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
public class Wallet {
    private int id;
    private int balance;
    private int statusWalletId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "balance")
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "status_wallet_id")
    public int getStatusWalletId() {
        return statusWalletId;
    }

    public void setStatusWalletId(int statusWalletId) {
        this.statusWalletId = statusWalletId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wallet wallet = (Wallet) o;

        if (id != wallet.id) return false;
        if (balance != wallet.balance) return false;
        if (statusWalletId != wallet.statusWalletId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + balance;
        result = 31 * result + statusWalletId;
        return result;
    }
}
