package com.capgemini.project.microservice_ticket.hystrixes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.capgemini.project.microservice_ticket.models.GettingPassenger;
import com.capgemini.project.microservice_ticket.models.PassengerConveter;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class HystrixForPassenger {

    @Autowired
    private RestTemplate rt;

    public PassengerConveter getFallBackTicketpassenger(GettingPassenger g){
        return (new PassengerConveter(null));
    }

    @HystrixCommand(fallbackMethod = "getFallBackTicketpassenger",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="2000"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
   })
   // this will fectch the data from the passenger microservice on base of train number, data, station1 index and station2 index
    public PassengerConveter hskjjk(@RequestBody GettingPassenger g){
        // String a="http://localhost:8092/passenger/traindate/"+trainno+"/"+date+"/"+si+"/"+di;
        // System.out.println("$$$$$$$$$$$$$$$$$$$$$$ "+a);
        PassengerConveter jh= rt.postForObject("http://passenger-service/passenger/traindate",g, PassengerConveter.class);
        return jh;
    }

    
}
