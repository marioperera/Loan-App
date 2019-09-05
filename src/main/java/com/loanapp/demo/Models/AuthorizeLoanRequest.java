package com.loanapp.demo.Models;

public class AuthorizeLoanRequest {
    private String AuthorizerUsername;
    private String AuthorizeeUsername;

    public String getAuthorizerUsername() {
        return AuthorizerUsername;
    }

    public void setAuthorizerUsername(String authorizerUsername) {
        AuthorizerUsername = authorizerUsername;
    }

    public String getAuthorizeeUsername() {
        return AuthorizeeUsername;
    }

    public void setAuthorizeeUsername(String authorizeeUsername) {
        AuthorizeeUsername = authorizeeUsername;
    }
}
