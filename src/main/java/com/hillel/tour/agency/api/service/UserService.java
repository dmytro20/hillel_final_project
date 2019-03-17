package com.hillel.tour.agency.api.service;

import com.hillel.tour.agency.api.dto.UserDTO;
import com.hillel.tour.agency.api.entity.User;

import java.util.List;

public interface UserService
{
    UserDTO submitUser(UserDTO userDTO);

    List<UserDTO> getPendingUsers();

    User approveUserById(String id);
}
