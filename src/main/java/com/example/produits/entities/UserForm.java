package com.example.produits.entities;

import javax.validation.constraints.Size;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

public class UserForm {
    @NotNull
    private String username;
    @NotNull
    @Size(min = 8, max = 15)
    private String password;
    @NotNull
    @Size(min = 8, max = 15)
    private String confirmedPassword;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmedPassword() {
        return confirmedPassword;
    }
    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
    
}
