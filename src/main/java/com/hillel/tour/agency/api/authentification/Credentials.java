package com.hillel.tour.agency.api.authentification;


import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Credentials implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public Credentials setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Credentials setPassword(String password) {
        this.password = password;
        return this;
    }
}

