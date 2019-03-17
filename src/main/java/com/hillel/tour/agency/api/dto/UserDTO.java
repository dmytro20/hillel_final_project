package com.hillel.tour.agency.api.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document(collection = "users")
public class UserDTO
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String login;
    private String firstName;
    private String lastName;
    private String passwordHash;

    public String getId()
    {
        return id;
    }

    public String getLogin()
    {
        return login;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

    @Override
    public String toString()
    {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                '}';
    }
}
