package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
public class Subscription {
    private int id;
    private int userId;
    private int productId;
    private int statusSubId;
    private Customer customerByUserId;
    private Product productByProductId;
    private StatusSub statusSubByStatusSubId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "status_sub_id")
    public int getStatusSubId() {
        return statusSubId;
    }

    public void setStatusSubId(int statusSubId) {
        this.statusSubId = statusSubId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscription that = (Subscription) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (productId != that.productId) return false;
        if (statusSubId != that.statusSubId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + productId;
        result = 31 * result + statusSubId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public Customer getCustomerByUserId() {
        return customerByUserId;
    }

    public void setCustomerByUserId(Customer customerByUserId) {
        this.customerByUserId = customerByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "status_sub_id", referencedColumnName = "id", nullable = false)
    public StatusSub getStatusSubByStatusSubId() {
        return statusSubByStatusSubId;
    }

    public void setStatusSubByStatusSubId(StatusSub statusSubByStatusSubId) {
        this.statusSubByStatusSubId = statusSubByStatusSubId;
    }
}
