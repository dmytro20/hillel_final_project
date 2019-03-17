package com.hillel.tour.agency.api.mapper.impl;

import com.hillel.tour.agency.api.dto.UserDto;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.mapper.Mapper;
import org.springframework.stereotype.Component;


@Component
public class UserMapper implements Mapper<UserDto,User> {

    @Override
    public User mapToEntity(UserDto userDto){
        return new User(userDto);
    }

    @Override
    public UserDto mapToDto(User user){
        return new UserDto(user);
    }
}
