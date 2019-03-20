package com.hillel.tour.agency.api.dto;

import com.hillel.tour.agency.api.entity.User;

import java.io.Serializable;
import java.util.Objects;

public final class UserDto
    implements Serializable
{

    private final Integer id;
    private final String  login;
    private final String  firstName;
    private final String  lastName;

    public UserDto(User user)
    {
        this.id = user.getId();
        this.login = user.getLogin();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

    public UserDto(Integer id,
                   String login,
                   String firstName,
                   String lastName)
    {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId()
    {
        return id;
    }

    public String getLogin()
    {
        return login;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) &&
               Objects.equals(login, userDto.login) &&
               Objects.equals(firstName, userDto.firstName) &&
               Objects.equals(lastName, userDto.lastName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, login, firstName, lastName);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("UserDto{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
