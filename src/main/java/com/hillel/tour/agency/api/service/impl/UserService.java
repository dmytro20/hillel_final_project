package com.hillel.tour.agency.api.service.impl;

import com.hillel.tour.agency.api.authentification.Credentials;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.repository.postgre.UserRepository;
import com.hillel.tour.agency.api.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements Services <User, Integer> {
    @Autowired
    UserRepository userRepository;

    @Override
    public User get(Integer id) {
        return userRepository.findOne(id);
    }

    public User get(Credentials credentials){
        List<User> list = userRepository.findAll();
        for (User user: list){
            if(user.getLogin() == credentials.getUsername()
            && user.getPassword() == credentials.getPassword()){
                return user;
            }
        }
        return null;
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