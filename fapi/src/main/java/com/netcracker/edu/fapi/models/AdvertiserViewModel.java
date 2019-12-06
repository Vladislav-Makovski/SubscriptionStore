package com.netcracker.edu.fapi.models;

public class AdvertiserViewModel {
    private int id;
    private String name;
    private int walletId;
    private int userDetailsId;

    public AdvertiserViewModel() {
    }

    public AdvertiserViewModel(int id, String name, int walletId, int userDetailsId) {
        this.id = id;
        this.name = name;
        this.walletId = walletId;
        this.userDetailsId = userDetailsId;
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

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public int getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(int userDetailsId) {
        this.userDetailsId = userDetailsId;
    }
}
