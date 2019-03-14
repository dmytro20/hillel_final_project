package com.hillel.tour.agency.api.repository.dao;

import com.hillel.tour.agency.api.entity.Login;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserValidationDao {
    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void register(User user) {
        String sqlQuery = "INSERT INTO users VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(sqlQuery,
                user.getId(),
                user.getLogin(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getRole());

    }

    public User validateUser(Login login) {
        String sqlQuery = "SELECT * FROM users WHERE login = '"
                + login.getUserName() + "' and password = '"
                + login.getUserPassword() + "'";
        List<User> users = jdbcTemplate.query(sqlQuery, new UserMapper());
        return  users.size() > 0 ? users.get(0) : null;
    }
}
