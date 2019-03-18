package com.hillel.tour.agency.api.mapper.impl;

import com.hillel.tour.agency.api.dto.UserDTO;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<UserDTO, User>
{

    @Override
    public User mapToEntity(UserDTO userDTO)
    {
        return new User(
                userDTO.getLogin(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getPasswordHash(),
                "user"
        );
    }

    @Override
    public UserDTO mapToDTO(User entity)
    {
        throw new UnsupportedOperationException();
    }
}
