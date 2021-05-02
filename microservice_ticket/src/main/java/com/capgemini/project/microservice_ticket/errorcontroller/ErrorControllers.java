package com.capgemini.project.microservice_ticket.errorcontroller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorControllers implements ErrorController{
    @RequestMapping("/error")
    public String handleError(HttpServletResponse response) {
       
 
        if(response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            return "manikant 404";
        }
        else if(response.getStatus() == HttpStatus.FORBIDDEN.value()) {
            return "manikant 500";
        }
        else if(response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return "manikant 400";
        }
        else {
            return "manikant";
        }
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}