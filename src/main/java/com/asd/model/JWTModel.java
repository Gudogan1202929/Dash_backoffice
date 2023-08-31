package com.asd.model;

public class JWTModel {

    private String JWTToken;

    public JWTModel(String JWTToken) {
        this.JWTToken = JWTToken;
    }

    public JWTModel() {
    }

    public String getJWTToken() {
        return JWTToken;
    }

    public void setJWTToken(String JWTToken) {
        this.JWTToken = JWTToken;
    }

    @Override
    public String toString() {
        return JWTToken;
    }
}
