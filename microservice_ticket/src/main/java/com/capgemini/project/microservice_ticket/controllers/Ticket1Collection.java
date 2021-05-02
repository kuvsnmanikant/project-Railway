package com.capgemini.project.microservice_ticket.controllers;

import com.capgemini.project.microservice_ticket.services.Ticket1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.capgemini.project.microservice_ticket.models.Ticket;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ticket")
public class Ticket1Collection {

    // it will creat the instance of the Ticket1Service
    @Autowired
    private Ticket1Service ts;

    // it will return all the price details of all types of trains
    @GetMapping("/allticket")
    public List<Ticket> findAllTickets() {
        return ts.findAllTickets();
    }

    // it will return the  data of a train by its type
    @GetMapping("/tickettype/{type}")
    public Ticket findByTrainType(@PathVariable String type) {
        return ts.findByTrainType(type);
    }

    // it will add the price details of a new train type
    @PostMapping("/addtickettype")
    public String addTraintype(@RequestBody Ticket t) {
        return ts.addTraintype(t);
    }

    // it will update the existing data  by train type
    @PutMapping("/updateticket/{s}")
    public String updateTicket(Ticket p, String s) {
        return ts.updateTicket(p, s);
    }
}
