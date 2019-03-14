package com.hillel.tour.agency.api.mapper;

import com.hillel.tour.agency.api.dto.UserDto;
import com.hillel.tour.agency.api.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setPassword(rs.getString("password_hash"));
        user.setRole(rs.getString("role"));
        return user;
    }

    public User mapToEntity(UserDto userDto){
        return new User().setId(userDto.getId())
                .setLogin(userDto.getLogin())
                .setFirstName(userDto.getFirstName())
                .setLastName(userDto.getLastName())
                .setPassword(userDto.getPassword())
                .setRole(userDto.getRole());
    }

    public UserDto mapToDto(User user){
        return new UserDto().setId(user.getId())
                .setLogin(user.getLogin())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPassword(user.getPassword())
                .setRole(user.getRole());
    }
}
