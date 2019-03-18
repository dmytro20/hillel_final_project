package com.hillel.tour.agency.api.service;

import com.hillel.tour.agency.api.auth.Credentials;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.repository.postgre.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface UserService extends Service<User, Integer>
{
    Optional<User> getUser(String userName);

}
