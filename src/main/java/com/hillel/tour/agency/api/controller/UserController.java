package com.hillel.tour.agency.api.controller;

import com.hillel.tour.agency.api.dto.UserDto;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.mapper.impl.UserMapper;
import com.hillel.tour.agency.api.service.UserService;
import com.hillel.tour.agency.api.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    private UserUtil userUtil;
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
}
