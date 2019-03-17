package com.hillel.tour.agency.api.controller;

import com.hillel.tour.agency.api.dto.UserDTO;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserDTO> submitUser(@RequestBody UserDTO userDTO)
    {
        if (!Validator.validateUserDTO(userDTO))
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        ResponseEntity<UserDTO> response;
        try
        {
            response = new ResponseEntity<>(userService.submitUser(userDTO), HttpStatus.CREATED);
        } catch (IllegalArgumentException e)
        {
            response = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return response;
    }

    // ADMIN ONLY FUNCTIONALITY

    @GetMapping("/users/pending")
    public ResponseEntity<List<UserDTO>> getPendingUsers()
    {
        return new ResponseEntity<>(userService.getPendingUsers(), HttpStatus.OK);
    }

    @PostMapping("/users/approve/{id}")
    public ResponseEntity<User> approveUserById(@PathVariable String id)
    {
        if (!Validator.validateId(id))
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        ResponseEntity<User> response;
        try
        {
            response =new ResponseEntity<>(userService.approveUserById(id), HttpStatus.CREATED);
        } catch (IllegalArgumentException e)
        {
            response = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return response;
    }


    private static class Validator
    {
        public static boolean validateUserDTO(UserDTO userDTO)
        {
            return (userDTO != null &&
                    userDTO.getLogin().matches("[a-zA-Z0-9_]{1,100}") &&
                    userDTO.getFirstName().matches("[a-zA-Z0-9_]{1,100}") &&
                    userDTO.getLastName().matches("[a-zA-Z0-9_]{1,100}") &&
                    userDTO.getPasswordHash().matches("[a-zA-Z0-9]{1,255}"));
        }

        public static boolean validateId(String id)
        {
            return id != null && id.matches("[a-fA-F0-9]{24}");
        }
    }
}


