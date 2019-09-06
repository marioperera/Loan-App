package com.loanapp.demo.Models;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private String role;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getJwttoken() {
        return jwttoken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public JwtResponse(String jwttoken,String role) {
        this.jwttoken = jwttoken;
        this.role =role;
    }

    public String getToken() {
        return this.jwttoken;
    }
}