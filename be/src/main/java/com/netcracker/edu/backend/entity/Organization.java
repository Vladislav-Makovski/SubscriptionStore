package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
public class Organization {
    private int id;
    private String name;
    private Integer walletId;
    private int userDetailsId;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "wallet_id")
    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
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

        Organization that = (Organization) o;

        if (id != that.id) return false;
        if (userDetailsId != that.userDetailsId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (walletId != null ? !walletId.equals(that.walletId) : that.walletId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (walletId != null ? walletId.hashCode() : 0);
        result = 31 * result + userDetailsId;
        return result;
    }
}
