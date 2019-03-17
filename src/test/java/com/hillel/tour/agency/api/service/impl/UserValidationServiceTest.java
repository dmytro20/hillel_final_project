package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.dto.UserDto;
import com.hillel.tour.agency.api.validation.UserValidationService;
import org.junit.Test;

public class UserValidationServiceTest {

    @Test
    public void register() {
    }

    @Test
    public void validate() {
        Login login = new Login()
                .setUserName("login")
                .setUserPassword("password");
        Integer id = 2;
        UserDto userDto =
        new UserValidationService()
                .validate(login, id);
        assertEquals(userDto.getLogin(), login.getUserName());
        assertEquals(userDto.getPassword(),login.getUserPassword());
    }
}