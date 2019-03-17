package com.hillel.tour.agency.api.validation;

import com.hillel.tour.agency.api.dto.UserDto;
import com.hillel.tour.agency.api.repository.postgre.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidationService {

    @Autowired
    UserRepository userRepository;

    public  boolean validate(UserDto dto){
        if(dto.getId() != null &&
        dto.getLogin() != null &&
        dto.getFirstName() != null &&
        dto.getLastName() != null &&
        dto.getPassword() != null)
        return true;
        else return false;
    }

    public UserDto login(String login, String password){  //todo: realization
        return null;
    }
}
