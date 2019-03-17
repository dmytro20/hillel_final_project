package com.hillel.tour.agency.api.Mapper;

import com.hillel.tour.agency.api.dto.UserDTO;
import com.hillel.tour.agency.api.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<UserDTO, User>
{

    @Override
    public User map(UserDTO userDTO)
    {
        return new User(
                userDTO.getLogin(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getPasswordHash(),
                "user"
        );
    }
}
