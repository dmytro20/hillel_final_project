package com.hillel.tour.agency.api.repository.mongo;

import com.hillel.tour.agency.api.dto.UserDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface UserMongoRepository extends MongoRepository<UserDTO, String>
{
    List<UserDTO> findByLogin(String login);
}
