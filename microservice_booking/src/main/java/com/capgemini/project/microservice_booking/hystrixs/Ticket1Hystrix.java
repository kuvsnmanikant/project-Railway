package com.capgemini.project.microservice_booking.hystrixs;

import com.capgemini.project.microservice_booking.models.Ticket;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Ticket1Hystrix {

    @Autowired
    private RestTemplate rt;

    public Ticket getFallBackTicket(String train_type){
        
        return new Ticket("","", null);
    }
    @HystrixCommand(fallbackMethod = "getFallBackTicket",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="2000"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
       
    }
    // ### without using circute breakers and using bulkhead pattern
    // threadPoolKey="TicketPool",
    // threadPoolProperties={
    //     @HystrixProperty(name ="coreSize",value="20"),
    //     @HystrixProperty(name = "maxQueueSize",value = "10")
    // }
   )
   // thhs will fetch the data from the ticket microervice
    public Ticket getTicket(String train_type){
        return rt.getForObject("http://ticket-service/ticket/tickettype/"+train_type, Ticket.class);
    }
    
}
