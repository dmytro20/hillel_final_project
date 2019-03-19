package com.hillel.tour.agency.api.auth;

import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.exceptions.InvalidAuthTokenException;
import com.hillel.tour.agency.api.exceptions.InvalidUserCredentialsException;
import com.hillel.tour.agency.api.exceptions.UserAuthException;
import com.hillel.tour.agency.api.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Component
public class Session {
    private static final Integer TOKEN_LIFE_TIME = 60 * 60 * 1000; //3600000 mc = 1h
    private static final String SIGN = ":hillel";

    private Map<String, Credentials> session;

    @Autowired
    private UserService _userService;

    @PostConstruct
    private void init() {
        if (session == null) {
            session = new LinkedHashMap<>();
        }
    }

    public Token authorize(Credentials creds) {
        Optional<User> user = _userService.getUser(creds.getUsername());

        if (!user.isPresent() || !user.get().getPassword().equals(creds.getPassword())) {
            throw new UserAuthException();
        }

        String token = DigestUtils.md5Hex(creds.getUsername() + creds.getPassword() + SIGN);

        session.put(token, creds);

        return new Token(token, new Date(creds.getCreatedDate()));
    }

    public Optional<User> getAuthority(String token) {
        Objects.requireNonNull(token);

        Credentials credentials = session.get(token);

        if (credentials == null || credentials.getCreatedDate() - System.currentTimeMillis() > TOKEN_LIFE_TIME) {
            throw new InvalidAuthTokenException();
        }

        return _userService.getUser(credentials.getUsername());
    }

    public boolean idAuthorized(String token) {
        Objects.requireNonNull(token);

        Credentials credentials = session.get(token);

        if (credentials == null || credentials.getCreatedDate() - System.currentTimeMillis() > TOKEN_LIFE_TIME) {
            throw new InvalidAuthTokenException();
        }

        return true;
    }

    public void unauthorize(String token) {
        session.remove(token);
    }

}
