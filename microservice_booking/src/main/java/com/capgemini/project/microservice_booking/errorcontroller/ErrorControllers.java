package com.capgemini.project.microservice_booking.errorcontroller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ErrorControllers implements ErrorController{
    @RequestMapping("/error")
    public String handleError(HttpServletResponse response) {
       
        // this will return this message when there is no data found in the database
        if(response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            return "manikant 404";
        }
        // this will return the message when the function is forbiden
        else if(response.getStatus() == HttpStatus.FORBIDDEN.value()) {
            return "manikant 403";
        }
        // this will return the message when there is an internal errror
        else if(response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return "manikant 500";
        }
        // any other errors
        else {
            return "manikant";
        }
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}





