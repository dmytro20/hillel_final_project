package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.dto.UserDto;
import com.hillel.tour.agency.api.entity.Login;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.exceptions.MyException;
import com.hillel.tour.agency.api.mapper.UserMapper;
import com.hillel.tour.agency.api.repository.postgre.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidationService {

    @Autowired
    UserRepository userRepository;

    private UserMapper userMapper;

    public void register(UserDto userDto) {
        if (userDto != null) {
            User user = userMapper.mapToEntity(userDto);
            userRepository.save(user);
        } else {
            throw new MyException("User data must be not null");
        }
    }

    public UserDto validate(Login login, Integer id) {
        User user = userRepository.findOne(id);
        if(login.getUserName() == user.getLogin() &&
        login.getUserPassword() == user.getPassword()){
            return userMapper.mapToDto(user);
        }else throw new MyException("Invalid login/password/id");

    }

}
