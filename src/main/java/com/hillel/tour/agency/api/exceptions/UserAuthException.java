package com.hillel.tour.agency.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UserAuthException
    extends RuntimeException
{
    public UserAuthException()
    {
        super();
    }

    public UserAuthException(String message)
    {
        super(message);
    }

    public UserAuthException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
