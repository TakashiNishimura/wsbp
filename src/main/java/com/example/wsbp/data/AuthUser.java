package com.example.wsbp.data;

import java.io.Serializable;

public class AuthUser implements Serializable {

    private String userName;
    private String userPass;

    public AuthUser() {
        userName = "";
        userPass = "";
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

}
