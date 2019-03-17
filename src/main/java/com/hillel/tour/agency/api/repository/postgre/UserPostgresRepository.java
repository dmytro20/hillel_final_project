package com.hillel.tour.agency.api.repository.postgre;

import com.hillel.tour.agency.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserPostgresRepository extends JpaRepository<User, String>
{
    List<User> findByLogin(String login);
}
