package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.mapper.Mapper;
import com.hillel.tour.agency.api.dto.UserDTO;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.repository.mongo.UserMongoRepository;
import com.hillel.tour.agency.api.repository.postgre.UserPostgresRepository;
import com.hillel.tour.agency.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    private UserMongoRepository userMongoRepository;
    private UserPostgresRepository userPostgresRepository;

    private Mapper<UserDTO, User> userMapper;

    @Autowired
    public UserServiceImpl(UserMongoRepository userMongoRepository,
                           UserPostgresRepository userPostgresRepository,
                           Mapper<UserDTO, User> userMapper)
    {
        this.userMongoRepository = userMongoRepository;
        this.userPostgresRepository = userPostgresRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO submitUser(UserDTO userDTO)
    {
        // Checks if the specified login is taken
        if (!userMongoRepository.findByLogin(userDTO.getLogin()).isEmpty())
            throw new IllegalArgumentException("Login is already taken");

        if (!userPostgresRepository.findByLogin(userDTO.getLogin()).isEmpty())
            throw new IllegalArgumentException(("Login is already taken"));

        return userMongoRepository.save(userDTO);
    }

    @Override
    public List<UserDTO> getPendingUsers()
    {
        return userMongoRepository.findAll();
    }

    @Override
    public User approveUserById(String id)
    {
        UserDTO toBeApproved = userMongoRepository.findOne(id);
        if (toBeApproved == null)
            throw new IllegalArgumentException("User not found in pending");

        User approvedUser = userPostgresRepository.save(userMapper.mapToEntity(toBeApproved));
        userMongoRepository.delete(id);
        return approvedUser;
    }
}
