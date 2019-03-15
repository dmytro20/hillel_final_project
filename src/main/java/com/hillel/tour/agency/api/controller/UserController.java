package com.hillel.tour.agency.api.controller;


import com.hillel.tour.agency.api.dto.UserDto;
import com.hillel.tour.agency.api.entity.Login;
import com.hillel.tour.agency.api.exceptions.MyException;
import com.hillel.tour.agency.api.service.impl.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements Controller {
    @Autowired
    private UserValidationService userValidationService;


    @PostMapping
    public void registerUser(Integer id, String login, String firstName,
                             String lastName, String password, String role){
        UserDto userDto = new UserDto()
                .setId(id)
                .setLogin(login)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword(password)
                .setRole(role);
        userValidationService.register(userDto);
    }

    @GetMapping
    public String[] validate(String login, String password,Integer id) {
        if(login != null && password != null && id != null){
           UserDto userDto = userValidationService.validate(new Login()
                    .setUserName(login)
                    .setUserPassword(password), id);
           String[] result = {userDto.getLogin(),userDto.getRole()};
           return result;
        }else {
           throw new MyException("Login/password/id must be not null");
        }
    }
}
