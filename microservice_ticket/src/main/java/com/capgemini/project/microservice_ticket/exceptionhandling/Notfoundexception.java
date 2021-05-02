package com.capgemini.project.microservice_ticket.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Notfoundexception extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public Notfoundexception(String message) {
		super(message);
	}
}