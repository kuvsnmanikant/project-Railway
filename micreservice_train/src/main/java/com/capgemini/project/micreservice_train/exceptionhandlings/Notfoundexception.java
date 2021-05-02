 package com.capgemini.project.micreservice_train.exceptionhandlings;
// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.ResponseStatus;

// @ResponseStatus(HttpStatus.NOT_FOUND)
// public class Notfoundexception extends RuntimeException{
//     private static final long serialVersionUID = 1L;

//     // this constructor will return the customized message for not found
//     public Notfoundexception(String message) {
// 		super(message);
// 	}
// }

public class Notfoundexception extends Exception {

  private static final long serialVersionUID = 1L;

  // this constructor will return the message when the data is not found
  public Notfoundexception(String message) {
    super(message);

  }
}