package com.hillel.tour.agency.api.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public final class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String role;

    public Integer getId() {
        return id;
    }

    public UserDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public UserDto setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserDto setRole(String role) {
        this.role = role;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return getId().equals(userDto.getId()) &&
                getLogin().equals(userDto.getLogin()) &&
                getPassword().equals(userDto.getPassword()) &&
                getFirstName().equals(userDto.getFirstName()) &&
                getLastName().equals(userDto.getLastName()) &&
                getRole().equals(userDto.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(),
                getPassword(), getFirstName(),
                getLastName(), getRole());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDto{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", role='").append(role).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
