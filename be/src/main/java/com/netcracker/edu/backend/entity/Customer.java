package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
public class Customer {
    private int id;
    private String firstName;
    private String surname;
    private int userDetailsId;
    private Wallet walletByWalletId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "user_details_id")
    public int getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(int userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (userDetailsId != customer.userDetailsId) return false;
        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (surname != null ? !surname.equals(customer.surname) : customer.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + userDetailsId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    public Wallet getWalletByWalletId() {
        return walletByWalletId;
    }

    public void setWalletByWalletId(Wallet walletByWalletId) {
        this.walletByWalletId = walletByWalletId;
    }
}
