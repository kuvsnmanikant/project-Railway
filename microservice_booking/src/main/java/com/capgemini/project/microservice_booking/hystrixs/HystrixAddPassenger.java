package com.capgemini.project.microservice_booking.hystrixs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import com.capgemini.project.microservice_booking.models.Passenger;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class HystrixAddPassenger {

    @Autowired
    private RestTemplate rt;

    public String getFallBackAddpassenger(Passenger g){
        return "faild";
    }

    // this is circute breake for the getaddpassenger
    @HystrixCommand(fallbackMethod = "getFallBackAddpassenger",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="2000"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
   })
   //this is the method which will fetch the data from the passenger microservice 
    public String getAddPassenger(@RequestBody Passenger g){
        // String a="http://localhost:8092/passenger/traindate/"+trainno+"/"+date+"/"+si+"/"+di;
        // System.out.println("$$$$$$$$$$$$$$$$$$$$$$ "+a);
        String jh= rt.postForObject("http://passenger-service/passenger/passengeradd",g, String.class);
        return jh;
    }

    
}

