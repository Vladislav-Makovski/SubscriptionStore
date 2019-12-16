package com.netcracker.edu.fapi.models;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private int id;
    private int userDetailsId;
    private int walletId;
    private String userRole;

    public JwtResponse(String jwttoken, int id, int userDetailsId, int walletId,String userRole) {
        this.jwttoken = jwttoken;
        this.id = id;
        this.userDetailsId = userDetailsId;
        this.walletId = walletId;
        this.userRole = userRole;
    }

    public String getJwttoken() {
        return this.jwttoken;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserDetailsId() {
        return this.userDetailsId;
    }

    public void setUserDetailsId(int userDetailsId) {
        this.userDetailsId = userDetailsId;
    }

    public int getWalletId() {
        return this.walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
