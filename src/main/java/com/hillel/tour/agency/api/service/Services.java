package com.hillel.tour.agency.api.service;

import com.hillel.tour.agency.api.entity.User;

import java.util.List;

public interface Services {
    User get(Integer id);
    void save(User user);
    void delete(User user);
    List<User> getAll();

}
