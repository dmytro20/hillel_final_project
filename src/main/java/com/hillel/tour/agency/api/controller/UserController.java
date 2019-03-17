package com.hillel.tour.agency.api.controller;

import com.hillel.tour.agency.api.dto.UserDTO;
import com.hillel.tour.agency.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController
{
    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping(value = "/users/register", consumes = {"application/json"})
    public UserDTO submitUser(@RequestBody UserDTO userDTO)
    {
        if (!Validator.validateUserDTO(userDTO))
            throw new IllegalArgumentException("BAD"); //english is difficult today
        return userService.submitUser(userDTO);
    }

    // ADMIN ONLY FUNCTIONALITY

    @GetMapping("/users/pending")
    public List<UserDTO> getPendingUsers() //?? English is difficult
    {
        return userService.getPendingUsers();
    }

    @PostMapping("/users/approve/{id}")
    public void approveUserById(@PathVariable String id)
    {
        if (!Validator.validateId(id))
            throw new IllegalArgumentException("Bad Id");
        userService.approveUserById(id);
    }


    private static class Validator
    {
        public static boolean validateUserDTO(UserDTO userDTO)
        {
            return (userDTO != null &&
                    userDTO.getLogin().matches("[a-zA-Z0-9_]{1,100}") &&
                    userDTO.getPasswordHash().matches("[a-zA-Z0-9]{1,255}"));
        }

        public static boolean validateId(String id)
        {
            return id.matches("[a-fA-F0-9]{24}");
        }
    }
}


