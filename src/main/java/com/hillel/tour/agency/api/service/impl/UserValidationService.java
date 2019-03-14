package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.dto.UserDto;
import com.hillel.tour.agency.api.entity.Login;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.repository.dao.UserValidationDao;

public class UserValidationService {
    private UserValidationDao userValidationDao;

    public void register(UserDto userDto){

        userValidationDao.register(new User());
    }

    public UserDto validate(Login login){
        User user;
        user = userValidationDao.validateUser(login);
        return null;
    }

}
