package com.netcracker.edu.fapi.models;

public class NewCustomerViewModel {
    String firstName;
    String surname;
    int userDetailsId;
    int walletId;

    public NewCustomerViewModel() {
    }

    public NewCustomerViewModel(String firstName, String surname, int userDetailsId, int walletId) {
        this.firstName = firstName;
        this.surname = surname;
        this.userDetailsId = userDetailsId;
        this.walletId = walletId;
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

    public int getUserDetailsId() {
        return userDetailsId;
    }

    public void setUserDetailsId(int userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }
}
