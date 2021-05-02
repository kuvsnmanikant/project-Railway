package com.capgemini.project.microservice_booking.hystrixs;

import org.springframework.stereotype.Service;

import com.capgemini.project.microservice_booking.models.ListOfStationsAndCoaches;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.client.RestTemplate;
@Service
public class HystrixForTrain {

    @Autowired
    private RestTemplate rt;

    public ListOfStationsAndCoaches fallbackListOfStationsAndCoaches(String trainno, String coachtype){
        
        return new ListOfStationsAndCoaches(null,null);
    }
    @HystrixCommand(fallbackMethod = "fallbackListOfStationsAndCoaches",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="20000"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "50"),
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "50000"),
       
    })
    // this method will fetch the data from the train microservice useing resttemplate
    public ListOfStationsAndCoaches getListOfStationsAndCoaches(String trainno, String coachtype){
        System.out.println(trainno);
        System.out.print(coachtype);
         return rt.getForObject("http://train-service/train/listofstationsandcoaches/"+trainno+"/"+coachtype, ListOfStationsAndCoaches.class);
   // return rt.getForObject("http://localhost:8091/train/listofstationsandcoaches/"+trainno+"/"+coachtype, ListOfStationsAndCoaches.class);
   
     }
    
}
