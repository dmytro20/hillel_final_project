package com.hillel.tour.agency.api.controller;

import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


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
    public User registerUser(@RequestBody User user)
    {
        return userService.create(user);
    }
}
