package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.dto.UserDto;
import com.hillel.tour.agency.api.entity.Login;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.mapper.UserMapper;
import com.hillel.tour.agency.api.repository.dao.UserValidationDao;
import com.hillel.tour.agency.api.service.ExampleService;
import org.springframework.stereotype.Service;

@Service
public class UserValidationService implements ExampleService {

    private UserValidationDao userValidationDao;
    private UserMapper userMapper;

    public void register(UserDto userDto){
        User user = userMapper.mapToEntity(userDto);
        userValidationDao.register(user);
    }

    public UserDto validate(Login login){
        User user = userValidationDao.validateUser(login);
        return userMapper.mapToDto(user);
    }

    @Override
    public String getTestString() {
        throw new UnsupportedOperationException();
    }
}
