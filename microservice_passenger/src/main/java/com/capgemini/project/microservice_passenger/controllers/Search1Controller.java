package com.capgemini.project.microservice_passenger.controllers;

import java.util.List;

import com.capgemini.project.microservice_passenger.models.Passenger;
import com.capgemini.project.microservice_passenger.models.PassengerStatus;
import com.capgemini.project.microservice_passenger.services.Passenger1Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/search")
public class Search1Controller {

    @Autowired
    private Passenger1Service ps;

    // it will return the certain passenger list by pnr no.
    @GetMapping("/passengerpnr/{pnr}")
    public List<Passenger> findByPnr(@PathVariable String pnr) {
        return ps.findByPnr(pnr);
    }

// it will update the passenger details status to cancle by pnr number
    @GetMapping("/passengercancle/{pnr}")
    public String cancelledPassenger (@PathVariable String pnr){
        return ps.cancelledPassenger(pnr);
    }

    // it will return the passengers who are booked by the give user id
    @GetMapping("/passengerbooked_by/{booked_by}")
    public List<Passenger> findBybooked_by (@PathVariable String booked_by){
        return ps.findBybooked_by(booked_by);
    }
    
    // it will return the status of the passengers on the given pnr number
    @GetMapping("/passengerstatus/{pnr}")
    public PassengerStatus getStatus(@PathVariable String pnr){
        PassengerStatus p = ps.getStatus(pnr);
        return p;
    }

    // it will fetch the passenger data on base of tran number and date
    @GetMapping("/passengersdatetrain/{trainno}/{date}")
    public List<Passenger> PassengerDataTrain(@PathVariable String trainno,@PathVariable String date){
        return ps.PassengerDataTrain(trainno,date);
    }
}
