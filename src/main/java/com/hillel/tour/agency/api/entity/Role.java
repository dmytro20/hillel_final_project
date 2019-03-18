package com.hillel.tour.agency.api.entity;

public enum Role
{
    USER, OPERATOR, ADMIN;

    public Role fromString(String value)
    {
        return Role.valueOf(value.toUpperCase());
    }
}
