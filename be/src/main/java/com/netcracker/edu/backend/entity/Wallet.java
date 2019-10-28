package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Wallet {
    private int id;
    private int balance;
    private int statusWalletId;
    private Collection<Customer> customersById;
    private Collection<Organization> organizationsById;
    private StatusWallet statusWalletByStatusWalletId;

    @Id
    @Column(name = "id")
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

    @OneToMany(mappedBy = "walletByWalletId")
    public Collection<Customer> getCustomersById() {
        return customersById;
    }

    public void setCustomersById(Collection<Customer> customersById) {
        this.customersById = customersById;
    }

    @OneToMany(mappedBy = "walletByWalletId")
    public Collection<Organization> getOrganizationsById() {
        return organizationsById;
    }

    public void setOrganizationsById(Collection<Organization> organizationsById) {
        this.organizationsById = organizationsById;
    }

    @ManyToOne
    @JoinColumn(name = "status_wallet_id", referencedColumnName = "id", nullable = false)
    public StatusWallet getStatusWalletByStatusWalletId() {
        return statusWalletByStatusWalletId;
    }

    public void setStatusWalletByStatusWalletId(StatusWallet statusWalletByStatusWalletId) {
        this.statusWalletByStatusWalletId = statusWalletByStatusWalletId;
    }
}
