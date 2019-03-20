package com.hillel.tour.agency.api.auth;

import com.hillel.tour.agency.api.entity.User;
import org.springframework.stereotype.Component;

@Component
public class SecurityContextHolder {
    private static final ThreadLocal<User> threadLocalScope = new  ThreadLocal<>();

    public final static User getLoggedUser() {
        return threadLocalScope.get();
    }

    public final static void setLoggedUser(User user) {
        threadLocalScope.set(user);
    }

}
