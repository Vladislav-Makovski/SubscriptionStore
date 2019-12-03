package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerViewModel {
    int id;
    String firstName;
    String surname;
    Integer walletId;
    int userDetailsId;

    public CustomerViewModel() {
    }

    public CustomerViewModel(int id, String firstName, String surname, Integer walletId, int userDetailsId) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.walletId = walletId;
        this.userDetailsId = userDetailsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getWalletId() {
        return walletId;
    }

    public void setWalletId(Integer walletId) {
        this.walletId = walletId;
    }

    public int getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(int userDetailsId) {
        this.userDetailsId = userDetailsId;
    }
}
