package com.capgemini.project.microservice_passenger.controllers;

import java.util.List;
import com.capgemini.project.microservice_passenger.models.GettingPassenger;
import com.capgemini.project.microservice_passenger.models.Passenger;
import com.capgemini.project.microservice_passenger.models.PassengerConveter;
import com.capgemini.project.microservice_passenger.services.Passenger1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/passenger")
public class Passenger1Controller {
 
    // creating the instav=nce for Passenger1Service
    @Autowired
    private Passenger1Service ps;

    // it will return all passengers in the data base
    @GetMapping("/allpassengers")
    public List<Passenger> getAllPassengers() {
        return ps.getAllPassengers();
    }

    // it will return passenger data having the given pnr
    @GetMapping("/passengerpnr/{pnr}")
    public List<Passenger> findByPnr(@PathVariable String pnr) {
        return ps.findByPnr(pnr);
    }

    // it will return the passenger details who booked the certain train in certain date and filtering to book the  ticket by indexes
    @PostMapping("/traindate")
    public PassengerConveter findBytrainnoDate(@RequestBody GettingPassenger g){
        PassengerConveter pc= new PassengerConveter();
        pc.setP(ps.findBytrainnoDate(g.getTrainno(), g.getDate(),g.getA(),g.getB()));
        return pc;
    }

    // it will update the existng passnger details
    @PutMapping("/passengerupdate/{s}")
    public String updatePassenger(@RequestBody Passenger p, String s){
        return ps.updatePassenger(p, s);
    }

    // it will delete the passenger data by pnr number
    @GetMapping("/passengerdelete/{pnr}")
    public String deletePassenger(@PathVariable String pnr){
        return ps.deletePassenger(pnr);
    }

    // it will add the new passenger's
    @PostMapping("/passengeradd")
    public String addPassenge(@RequestBody Passenger t){
        return ps.addPassenge(t);
    }
}
