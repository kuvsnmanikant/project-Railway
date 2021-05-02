package com.capgemini.project.microservice_ticket.services;

import com.capgemini.project.microservice_ticket.models.Ticket;
import java.util.List;
import com.capgemini.project.microservice_ticket.databases.Ticket1Database;
import com.capgemini.project.microservice_ticket.exceptionhandling.Notfoundexception;
import com.capgemini.project.microservice_ticket.interfaces.Ticket1Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ticket1Service implements Ticket1Interface{

    // we are creating the instance of Ticket1Database
    @Autowired
    private Ticket1Database td;

    // it will fetch all data in the database
    public List<Ticket> findAllTickets(){
        return td.findAll();
    }

    // it will fetch the data from the database by train type
    public Ticket findByTrainType(String type){
        Ticket lt= td.findByTrainType(type);
        if (lt == null) {
            throw new Notfoundexception(" not exist");
        }
        return lt;
    }

    // it will add data to the data base
    public String addTraintype(Ticket t){
        Ticket a= td.findByTrainType(t.getTrain_type());
        if (a != null) {
            return "you can't add";
        }
        td.save(t);
        return "success";
    }

    // it will delete the data  in the database by train type
    public String deleteTraintype(String t){
        Ticket a= td.findByTrainType(t);
        if (a == null) {
            return "you can't delete";
        }
        td.deleteByTrainType(t);
        return "success";
    }

    // it will update the ticket by the train type
    public String updateTicket(Ticket p, String s) {
        Ticket a = td.findByTrainType(s);
        if (a == null) {
            throw new Notfoundexception(s + " not exist");
        }
        td.deleteByTrainType(s);
        td.save(p);
        return "success";
    }

}
