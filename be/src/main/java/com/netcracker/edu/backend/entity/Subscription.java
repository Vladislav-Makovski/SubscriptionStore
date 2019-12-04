package com.netcracker.edu.backend.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Subscription {
    private int id;
    private int userId;
    private int productId;
    private int statusSubId;
    private Date dateSub;

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

    @Basic
    @Column(name = "date_sub")
    public Date getDateSub() {
        return dateSub;
    }

    public void setDateSub(Date dateSub) {
        this.dateSub = dateSub;
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
        if (dateSub != null ? !dateSub.equals(that.dateSub) : that.dateSub != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + productId;
        result = 31 * result + statusSubId;
        result = 31 * result + (dateSub != null ? dateSub.hashCode() : 0);
        return result;
    }
}
