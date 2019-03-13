package com.hillel.tour.agency.api.repository.mongo;

import com.hillel.tour.agency.api.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<User, String>{
}
