package com.capgemini.project.micreservice_train.ErrorController;

import javax.servlet.http.HttpServletResponse;

import com.capgemini.project.micreservice_train.model.ErrorhandlerObject;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorControllers implements ErrorController{
    @RequestMapping("/error")
    public ErrorhandlerObject handleError(HttpServletResponse response) {

        // this will return the not found  message
        if(response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            ErrorhandlerObject e= new ErrorhandlerObject("manikant 404");
            return e;
        }

        // this will return the forbiden message
        else if(response.getStatus() == HttpStatus.FORBIDDEN.value()) {
            ErrorhandlerObject e= new ErrorhandlerObject("manikant 403");
            return e;
        }

        // this will return the internale error message
        else if(response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            ErrorhandlerObject e= new ErrorhandlerObject("manikant 500");
            return e;
        }

        // any other error 
        else {
            return new ErrorhandlerObject("mani");
        }
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}





