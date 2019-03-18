package com.hillel.tour.agency.api.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.hillel.tour.agency.api.auth.Credentials;
import com.hillel.tour.agency.api.auth.Session;
import com.hillel.tour.agency.api.dto.UserDto;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.mapper.impl.UserMapper;
import com.hillel.tour.agency.api.service.UserService;
import com.hillel.tour.agency.api.validation.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController extends Controller
{
    @Autowired
    private UserValidationService userValidationService;//todo: create/use Utils class
    @Autowired
    private UserService           userService;
    @Autowired
    private UserMapper            mapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id, HttpServletRequest request)
    {
        auth(request);

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

    @PostMapping("users/delete/id {id}")  //For delete you should use HTTP method DELETE and path = users/{id}
    //todo: TAA-13 not include this requirement, should be deleted
    public ResponseEntity<UserDto> delete(@PathVariable Integer id)
    {
        UserDto dto = mapper.mapToDto(userService.get(id));
        if (dto == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping //todo: TAA-13 not include this requirement, should be deleted
    public ResponseEntity<List<UserDto>> getAll()
    {
        List<User> users = userService.getAll();
        if (users == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<UserDto> result = new ArrayList<>();
        for (User user : users)
        {
            result.add(new UserDto(user));
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
