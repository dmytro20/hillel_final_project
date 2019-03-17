package com.hillel.tour.agency.api.authentification;


import com.hillel.tour.agency.api.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Session {
    private Map<Credentials, UserDto> map;

    public Session(){
        this.map = new HashMap<>();
    }

    public static Session getInstance(){
        return new Session();
    }

    public void add(Credentials cred, UserDto dto){
        map.put(cred, dto);
    }
    public UserDto get(Credentials credentials){
        return map.get(credentials);
    }

}
