package com.hillel.tour.agency.api.exceptions.handler;

import com.hillel.tour.agency.api.exceptions.InvalidAuthTokenException;
import com.hillel.tour.agency.api.exceptions.InvalidUserCredentialsException;
import com.hillel.tour.agency.api.exceptions.UserAuthException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler
{
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /*@ExceptionHandler(UserAuthException.class)
    public String handleSQLException(HttpServletRequest request, Exception ex){
        logger.info("SQLException Occured:: URL="+request.getRequestURL());
        return "database_error";
    }*/

    @ExceptionHandler({ UserAuthException.class })
    public ResponseEntity<Object> handleUserUnauthorizedException(Exception ex, HttpServletRequest request)
    {
        logger.warn("Unauthorized request: {}", ex.getMessage());

        return new ResponseEntity<>(
            "Unauthorized", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({ InvalidAuthTokenException.class })
    public ResponseEntity<Object> handleInvalidTokenException(Exception ex, HttpServletRequest request)
    {
        logger.warn("InvalidToken token: {}", ex.getMessage());

        return new ResponseEntity<>(
            "InvalidToken token", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({ InvalidUserCredentialsException.class })
    public ResponseEntity<Object> handleInvalidCredentialsException(Exception ex, HttpServletRequest request)
    {
        logger.warn("Invalid credentials exception: {}", ex.getMessage());

        return new ResponseEntity<>(
            "Invalid credentials", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
