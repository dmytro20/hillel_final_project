package com.hillel.tour.agency.api.controller;


import com.hillel.tour.agency.api.authentification.Credentials;
import com.hillel.tour.agency.api.authentification.Session;
import com.hillel.tour.agency.api.dto.UserDto;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.mapper.impl.UserMapper;
import com.hillel.tour.agency.api.service.impl.UserService;
import com.hillel.tour.agency.api.validation.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController implements Controller<UserDto, Integer> {
    @Autowired
    private UserValidationService userValidationService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper mapper;
    @Autowired
    private static Session session;

    @PostMapping
    public ResponseEntity<UserDto> login(Credentials credentials) {
        session = Session.getInstance();
        UserDto dto = mapper.mapToDto(userService.get(credentials));
        if (userValidationService.validate(dto)) {
            session.add(credentials.getUsername(), dto);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users/get/id {id}")
    @Override
    public ResponseEntity<UserDto> get(@PathVariable Integer id) {
        UserDto dto = mapper.mapToDto(userService.get(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

 /*   @PostMapping
    @Override
    public ResponseEntity<UserDto> post(@RequestBody UserDto dto) {
        if (userValidationService.validate(dto)) {
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    @Override
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto) {
        if (userValidationService.validate(dto)) {
            this.userService.save(mapper.mapToEntity(dto));
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/

    @PostMapping("users/delete/id {id}")
    @Override
    public ResponseEntity<UserDto> delete(@PathVariable Integer id) {
        UserDto dto = mapper.mapToDto(userService.get(id));
        if (dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("users/all")
    @Override
    public ResponseEntity<List<UserDto>> getAll() {
        List<User> users = userService.getAll();
        if (users == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<UserDto> result = new ArrayList<>();
        for (User user : users) {
            result.add(new UserDto(user));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
