package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConvertProductViewModel {
    private int id;
    private String name;
    private String description;
    private String category;
    private int cost;
    private int subscriptionCount;

    public ConvertProductViewModel() {
    }

    public ConvertProductViewModel(int id, String name, String description, String category, int cost, int subscriptionCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.cost = cost;
        this.subscriptionCount = subscriptionCount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSubscriptionCount(){return subscriptionCount;}

    public void setSubscriptionCount(int subscriptionCount){this.subscriptionCount = subscriptionCount;}
}
