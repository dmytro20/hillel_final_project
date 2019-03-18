package com.hillel.tour.agency.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidUserCredentialsException
    extends RuntimeException
{
    public InvalidUserCredentialsException()
    {
        super();
    }

    public InvalidUserCredentialsException(String message)
    {
        super(message);
    }

    public InvalidUserCredentialsException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
