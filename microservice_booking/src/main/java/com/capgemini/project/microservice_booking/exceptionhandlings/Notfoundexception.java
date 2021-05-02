package com.capgemini.project.microservice_booking.exceptionhandlings;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// this method is used to handle the exception of no found
@ResponseStatus(HttpStatus.NOT_FOUND)
public class Notfoundexception extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public Notfoundexception(String message) {
		super(message);
	}
}
