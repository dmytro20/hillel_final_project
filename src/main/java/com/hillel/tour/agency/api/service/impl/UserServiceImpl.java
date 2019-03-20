package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.repository.postgre.UserRepository;
import com.hillel.tour.agency.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl
    implements UserService
{
    @Autowired
    UserRepository userRepository;

    @Override
    public User get(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public Optional<User> getUser(String userName){
        return Optional.ofNullable(userRepository.findByLogin(userName));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {  //todo : realize me
        return null;
    }

    @Override
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> getAll() {

        return userRepository.findAll();

    }
}
