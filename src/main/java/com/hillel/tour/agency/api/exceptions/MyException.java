package com.hillel.tour.agency.api.exceptions;


import org.slf4j.Logger;

public class MyException extends RuntimeException {
    private Logger log;
    {
        try {
            log = Logger.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public MyException(String massage){
        log.info(massage);
    }
}
