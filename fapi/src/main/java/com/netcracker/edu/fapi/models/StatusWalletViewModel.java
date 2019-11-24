package com.netcracker.edu.fapi.models;

public class StatusWalletViewModel {

    private int id;
    private String name;

    public StatusWalletViewModel() {
    }

    public StatusWalletViewModel(int id, String name) {
        this.id = id;
        this.name = name;
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
        this.name =  name;
    }
}
