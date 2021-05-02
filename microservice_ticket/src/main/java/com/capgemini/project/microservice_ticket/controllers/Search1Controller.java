package com.capgemini.project.microservice_ticket.controllers;

import com.capgemini.project.microservice_ticket.models.TrainSearch;
import com.capgemini.project.microservice_ticket.services.Ticket1Service;
import com.capgemini.project.microservice_ticket.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.project.microservice_ticket.models.ConvertSearchDetails;
import com.capgemini.project.microservice_ticket.models.Ticket;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/search")
public class Search1Controller {

    @Autowired
    private TicketService t;

    @Autowired
    private Ticket1Service ts;

    // it will return the list of train from station1 to station2 by calculating the price
    @PostMapping("/searchtrains")
    public ConvertSearchDetails getTrain(@RequestBody TrainSearch ts){
        System.out.println(ts);
       return  t.getTrain(ts);
    }

    // it will find the price details of a trian by train type
    @GetMapping("/tickettype/{type}")
    public Ticket findByTrainType(@PathVariable String type) {
        return ts.findByTrainType(type);
    }
}
