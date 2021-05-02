package com.capgemini.project.microservice_booking.controllers;

import com.capgemini.project.microservice_booking.models.Booking;
import com.capgemini.project.microservice_booking.models.GetPassengerData;
import com.capgemini.project.microservice_booking.models.GetSendPriceDetails;
import com.capgemini.project.microservice_booking.models.ReturnPriceDetails;
import com.capgemini.project.microservice_booking.models.SendPriceDetails;
import com.capgemini.project.microservice_booking.services.Booking1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/booking")
public class Booking1Controller {

    @Autowired
    private Booking1Service bs;


    @PostMapping("/firststep")
    public SendPriceDetails getBokingList(@RequestBody GetSendPriceDetails gspd){
      return bs.sendPriceDetails(gspd);
     // return rt.getForObject("http://ticket-service/ticket/tickettype/"+gspd.getTrain_type(), Ticket.class);
    }

    // it will create the PNR number and assign the seat and update the passenger data base
    @PostMapping("/laststep")
    public String getPassengerData(@RequestBody GetPassengerData gpd){
      return bs.getPassengerData(gpd);
    }

    // this will calculate the price of the passengsers and return the data
    @PostMapping("/firststeps")
    public ReturnPriceDetails bookingFirstStep(@RequestBody GetPassengerData gspd){
      return bs.bookingFirstStep(gspd);
    }

    //this method is used to  fetch the data from the database by pnr number
    @GetMapping("/getpricedatabase/{pnr}")
    public Booking getPriceDetails(@PathVariable String pnr){
      return bs.getPriceDetails(pnr);
    }
    
}