package com.capgemini.project.microservice_ticket.interfaces;

import java.util.List;
import com.capgemini.project.microservice_ticket.models.Ticket;

// this is implemented by the Ticket1Service
public interface Ticket1Interface {
    public List<Ticket> findAllTickets();
    public String addTraintype(Ticket t);
    public String updateTicket(Ticket p, String s);
    
}
