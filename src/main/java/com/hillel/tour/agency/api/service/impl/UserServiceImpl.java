package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.repository.mongo.UserMongoRepository;
import com.hillel.tour.agency.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    private UserMongoRepository userMongoRepository;

    @Autowired
    public UserServiceImpl(UserMongoRepository userMongoRepository)
    {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public User create(User user)
    {
        //TODO VALIDATION????

        if (!userMongoRepository.findByLogin(user.getLogin()).isEmpty())
            throw new IllegalArgumentException("Login is already taken"); //TODO HANDLE THIS BETTER

        return userMongoRepository.save(user);
    }
}
