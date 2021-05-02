package com.capgemini.project.microsevice_apigateway.services;

import com.capgemini.project.microsevice_apigateway.databases.User1Database;
import com.capgemini.project.microsevice_apigateway.interfaces.User1Interfaces;
import com.capgemini.project.microsevice_apigateway.models.CommonMan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class User1Service implements User1Interfaces{
    @Autowired
    private User1Database ud;
    @Override
    public CommonMan getDetails(String id){
        return ud.findByName(id);
    }

    public String addUsers(CommonMan c){
        return "mana";
    }
}
