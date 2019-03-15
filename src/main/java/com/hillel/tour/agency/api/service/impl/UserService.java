package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.repository.postgre.UserRepository;
import com.hillel.tour.agency.api.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService implements Service {
    @Autowired
    UserRepository userRepository;

    @Override
    public User get(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
