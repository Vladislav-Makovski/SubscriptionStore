package com.netcracker.edu.fapi.models;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private Integer id;
    private String username;

    public JwtResponse(String jwttoken,int id ,String username) {
        this.jwttoken = jwttoken;
        this.id = id;
        this.username = username;
    }

    public String getToken() {
        return this.jwttoken;
    }

}
