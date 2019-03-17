package com.hillel.tour.agency.api.authentification;


import com.hillel.tour.agency.api.dto.UserDto;
import com.hillel.tour.agency.api.exceptions.MyException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Session {
    private Map<String, UserDto> map;

    public Session(){
        this.map = new HashMap<>();
    }

    public static Session getInstance(){
        return new Session();
    }

    public void add(String userName, UserDto dto){
        map.put(userName, dto);
    }
    public UserDto get(Credentials credentials){
        String userName = credentials.getUsername();
        if(userName != null)
        return map.get(userName);
        else throw new MyException("Credential name not valid");
    }

}
