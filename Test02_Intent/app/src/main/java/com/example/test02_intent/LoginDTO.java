package com.example.test02_intent;

import java.io.Serializable;

public class LoginDTO implements Serializable {
    private String id;
    private String pw;

    public LoginDTO(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    //public LoginDTO(EditText id, EditText pw) {
    //}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
