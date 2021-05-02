package com.capgemini.project.microsevice_apigateway.errorcontrollers;

import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorControllers implements ErrorController{
    @RequestMapping("/error")
    public String handleError(HttpServletResponse response) {

        // this will return the not found  message
        if(response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            return "manikant 404";
        }

        // this will return the forbiden message
        else if(response.getStatus() == HttpStatus.FORBIDDEN.value()) {
            return "manikant 403";
        }

        // this will return the internale error message
        else if(response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            return "manikant 500";
        }

        // any other error 
        else {
            return "manikant";
        }
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}