package com.hillel.tour.agency.api.service;

import com.hillel.tour.agency.api.dto.UserDTO;

import java.util.List;

public interface UserService
{
    UserDTO submitUser(UserDTO userDTO);

    List<UserDTO> getPendingUsers();

    void approveUserById(String id);
}
