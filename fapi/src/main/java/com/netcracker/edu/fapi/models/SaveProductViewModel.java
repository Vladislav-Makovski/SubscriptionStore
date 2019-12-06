package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SaveProductViewModel {
    private int id;
    private String name;
    private int cost;
    private int subscriptionCount;
    private int statusProductId;
    private int organizationId;
    private int categoryId;
    private String description;

    public SaveProductViewModel() {
    }

    public SaveProductViewModel(int id, String name, int cost, int subscriptionCount, int statusProductId, int organizationId, int categoryId, String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.subscriptionCount = subscriptionCount;
        this.statusProductId = statusProductId;
        this.organizationId = organizationId;
        this.categoryId = categoryId;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSubscriptionCount() {
        return subscriptionCount;
    }

    public void setSubscriptionCount(int subscriptionCount) {
        this.subscriptionCount = subscriptionCount;
    }

    public int getStatusProductId() {
        return statusProductId;
    }

    public void setStatusProductId(int statusProductId) {
        this.statusProductId = statusProductId;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
