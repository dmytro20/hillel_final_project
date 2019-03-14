package com.hillel.tour.agency.api.entity;

public class Login {
    private String userName;
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public Login setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Login setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Login{");
        sb.append("userName='").append(userName).append('\'');
        sb.append(", userPassword='").append(userPassword).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
