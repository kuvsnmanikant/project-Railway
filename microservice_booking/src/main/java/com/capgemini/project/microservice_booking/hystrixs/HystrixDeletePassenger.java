package com.capgemini.project.microservice_booking.hystrixs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class HystrixDeletePassenger {

    @Autowired
    private RestTemplate rt;

    public String getFallBackDeletepassenger(String g){
        return "faild";
    }

    @HystrixCommand(fallbackMethod = "getFallBackDeletepassenger",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="2000"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
   })
   // this method will fetch the data from the passenger microservice useing the resttemplate
    public String getDeletePassenger(String g){
        // String a="http://localhost:8092/passenger/traindate/"+trainno+"/"+date+"/"+si+"/"+di;
        // System.out.println("$$$$$$$$$$$$$$$$$$$$$$ "+a);
        String jh= rt.getForObject("http://passenger-service/passenger/passengerdelete/"+g, String.class);
        return jh;
    }

}
