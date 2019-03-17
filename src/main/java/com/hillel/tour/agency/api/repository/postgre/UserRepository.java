package com.hillel.tour.agency.api.repository.postgre;

import com.hillel.tour.agency.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
