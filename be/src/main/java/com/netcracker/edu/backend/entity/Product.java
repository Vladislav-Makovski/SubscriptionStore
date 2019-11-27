package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int cost;
    private int subscriptionCount;
    private Date date;
    private int statusProductId;
    private int organizationId;
    private int categoryId;
    private String description;

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
    @Column(name = "cost")
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "subscription_count")
    public int getSubscriptionCount() {
        return subscriptionCount;
    }

    public void setSubscriptionCount(int subscriptionCount) {
        this.subscriptionCount = subscriptionCount;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "status_product_id")
    public int getStatusProductId() {
        return statusProductId;
    }

    public void setStatusProductId(int statusProductId) {
        this.statusProductId = statusProductId;
    }

    @Basic
    @Column(name = "organization_id")
    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    @Basic
    @Column(name = "category_id")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (cost != product.cost) return false;
        if (subscriptionCount != product.subscriptionCount) return false;
        if (statusProductId != product.statusProductId) return false;
        if (organizationId != product.organizationId) return false;
        if (categoryId != product.categoryId) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (date != null ? !date.equals(product.date) : product.date != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + cost;
        result = 31 * result + subscriptionCount;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + statusProductId;
        result = 31 * result + organizationId;
        result = 31 * result + categoryId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
