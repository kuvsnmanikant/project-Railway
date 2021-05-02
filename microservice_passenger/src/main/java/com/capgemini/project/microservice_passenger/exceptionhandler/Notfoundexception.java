package com.capgemini.project.microservice_passenger.exceptionhandler;

public class Notfoundexception extends Exception {

  private static final long serialVersionUID = 1L;

  // this constructor will return the message when the data is not found
  public Notfoundexception(String message) {
    super(message);

  }
}
