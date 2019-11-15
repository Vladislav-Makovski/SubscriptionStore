package com.netcracker.edu.fapi.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductViewModel {

    private int id;
    private String name;
    private String description;
    private int categoryId;
    private int cost;
    private int subscriptionCount;

    public ProductViewModel() {
    }

    public ProductViewModel(int id, String name, String description,int categoryId, int cost,int subscriptionCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
