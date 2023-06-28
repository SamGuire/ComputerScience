package com.example.ormsandbox.common;

import java.io.Serializable;

public class LoginForm  implements Serializable {
    private String password;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

