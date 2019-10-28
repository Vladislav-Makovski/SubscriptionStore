package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Organization {
    private int id;
    private String name;
    private int walletId;
    private int userDetailsId;
    private Wallet walletByWalletId;
    private UserDetails userDetailsByUserDetailsId;
    private Collection<Product> productsById;

    @Id
    @Column(name = "id")
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
    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
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
        if (walletId != that.walletId) return false;
        if (userDetailsId != that.userDetailsId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + walletId;
        result = 31 * result + userDetailsId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "wallet_id", referencedColumnName = "id", nullable = false)
    public Wallet getWalletByWalletId() {
        return walletByWalletId;
    }

    public void setWalletByWalletId(Wallet walletByWalletId) {
        this.walletByWalletId = walletByWalletId;
    }

    @ManyToOne
    @JoinColumn(name = "user_details_id", referencedColumnName = "id", nullable = false)
    public UserDetails getUserDetailsByUserDetailsId() {
        return userDetailsByUserDetailsId;
    }

    public void setUserDetailsByUserDetailsId(UserDetails userDetailsByUserDetailsId) {
        this.userDetailsByUserDetailsId = userDetailsByUserDetailsId;
    }

    @OneToMany(mappedBy = "organizationByOrganizationId")
    public Collection<Product> getProductsById() {
        return productsById;
    }

    public void setProductsById(Collection<Product> productsById) {
        this.productsById = productsById;
    }
}
