package com.loanapp.demo.Models;

public class AuthorizedLoanResponse {
    private String response;
    private String clinetusername;

    public String getResponse() {
        return response;
    }

    public AuthorizedLoanResponse(String response, String clinetusername) {
        this.response = response;
        this.clinetusername = clinetusername;
    }

    public void setResponse(String response) {

        this.response = response;
    }

    public String getClinetusername() {
        return clinetusername;
    }

    public void setClinetusername(String clinetusername) {
        this.clinetusername = clinetusername;
    }
}
