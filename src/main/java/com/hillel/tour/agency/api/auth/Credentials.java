package com.hillel.tour.agency.api.auth;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Objects;

public class Credentials
{
    private final String username;
    private final String password;
    private final Long   createdDate;

    public Credentials(String username, String password)
    {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        this.username = username;
        this.password = DigestUtils.md5Hex(password);
        this.createdDate = System.currentTimeMillis();
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public Long getCreatedDate()
    {
        return createdDate;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Credentials that = (Credentials) o;
        return Objects.equals(username, that.username) &&
               Objects.equals(password, that.password) &&
               Objects.equals(createdDate, that.createdDate);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(username, password, createdDate);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Credentials{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", createdDate=").append(createdDate);
        sb.append('}');
        return sb.toString();
    }
}

