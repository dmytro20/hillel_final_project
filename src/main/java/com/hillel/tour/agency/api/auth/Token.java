package com.hillel.tour.agency.api.auth;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class Token
{
    private final String token;
    private final Date   expiredDate;

    public Token(String token, Date expiredDate)
    {
        this.token = token;
        this.expiredDate = expiredDate;
    }

    @JsonProperty("T-O-U-R-token")
    public String getToken()
    {
        return token;
    }

    @JsonProperty("expired_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    public Date getExpiredDate()
    {
        return expiredDate;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Token token1 = (Token) o;
        return Objects.equals(token, token1.token) &&
               Objects.equals(expiredDate, token1.expiredDate);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(token, expiredDate);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Token{");
        sb.append("token='").append(token).append('\'');
        sb.append(", expiredDate=").append(expiredDate);
        sb.append('}');
        return sb.toString();
    }
}
