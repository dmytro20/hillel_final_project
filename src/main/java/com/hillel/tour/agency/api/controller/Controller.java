package com.hillel.tour.agency.api.controller;

import com.hillel.tour.agency.api.auth.Credentials;
import com.hillel.tour.agency.api.auth.Session;
import com.hillel.tour.agency.api.auth.Token;
import com.hillel.tour.agency.api.entity.User;
import com.hillel.tour.agency.api.exceptions.InvalidAuthTokenException;
import com.hillel.tour.agency.api.exceptions.UserAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;


public abstract class Controller {
    @Autowired
    private Session session;

    @PostMapping(value = "/login")
    public ResponseEntity<Token> login(@RequestBody LoginDto loginDto) {
        if (!LoginDto.validate(loginDto)) {
            throw new InvalidAuthTokenException();
        }
        Token token = session.authorize(new Credentials(loginDto.getUsername(), loginDto.getPassword()));
        return ResponseEntity.ok(token);

    }

    protected User getUser(String token) {
        return session.getAuthority(token).orElseThrow(UserAuthException::new);
    }

    protected void auth(HttpServletRequest request) {
        String token = request.getHeader("T-O-U-R-token");

        if (StringUtils.isEmpty(token)) {
            throw new InvalidAuthTokenException();
        }

        session.idAuthorized(token);
    }

    private static class LoginDto {
        private String username;
        private String password;


        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        private static boolean validate(LoginDto loginDto){
            if(loginDto.getPassword() != null &&
                    loginDto.getUsername() != null &&
                    loginDto.getUsername().length() > 0 &&
                    loginDto.getPassword().length() > 0 )
                return true;
            else
                return false;
        }
    }
}
