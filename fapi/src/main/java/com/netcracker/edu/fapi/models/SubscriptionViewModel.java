package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionViewModel {
    int id;
    int userId;
    int productId;
    int statusSubId;

    public SubscriptionViewModel() {
    }

    public SubscriptionViewModel (int id, int userId, int productId, int statusSubId) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.statusSubId = statusSubId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStatusSubId() {
        return statusSubId;
    }

    public void setStatusSubId(int statusSubId) {
        this.statusSubId = statusSubId;
    }
}
