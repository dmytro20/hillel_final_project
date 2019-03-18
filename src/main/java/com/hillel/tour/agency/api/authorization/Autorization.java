package com.hillel.tour.agency.api.authorization;

import com.hillel.tour.agency.api.authentification.SecurityContextHolder;
import com.hillel.tour.agency.api.entity.User;

public class Autorization {
    void setRole(Role role) {
        User autorized = SecurityContextHolder.getLoggedUser();
        autorized.setRole(role);
        SecurityContextHolder.setLoggedUser(autorized);
    }
}
