package com.hillel.tour.agency.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class InvalidAuthTokenException extends RuntimeException
{
    public InvalidAuthTokenException()
    {
        super();
    }

    public InvalidAuthTokenException(String message)
    {
        super(message);
    }

    public InvalidAuthTokenException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
