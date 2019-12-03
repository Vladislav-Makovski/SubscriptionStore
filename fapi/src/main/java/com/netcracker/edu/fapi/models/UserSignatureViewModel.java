package com.netcracker.edu.fapi.models;

public class UserSignatureViewModel {
    int id;
    int userRole;
    int userDetailsId;
    int walletId;

    public UserSignatureViewModel() {
    }

    public UserSignatureViewModel(int id, int userRole, int userDetailsId, int walletId) {
        this.id = id;
        this.userRole = userRole;
        this.userDetailsId = userDetailsId;
        this.walletId = walletId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
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
