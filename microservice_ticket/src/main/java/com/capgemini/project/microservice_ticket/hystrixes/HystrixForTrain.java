package com.capgemini.project.microservice_ticket.hystrixes;

import com.capgemini.project.microservice_ticket.models.ConvertSearchDetails;
import com.capgemini.project.microservice_ticket.models.TrainSearch;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HystrixForTrain {

    @Autowired
    private RestTemplate rt;

    public ConvertSearchDetails getFallBackTicket(TrainSearch tr){
        return (new ConvertSearchDetails(null));
    }

     @HystrixCommand(fallbackMethod = "getFallBackTicket",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="2000"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
    })
    // this will fetch the data from the train microservice by station1, station2, date, general
    public ConvertSearchDetails getTrain(TrainSearch tr){

        ConvertSearchDetails c= rt.postForObject("http://train-service/search/trains",tr, ConvertSearchDetails.class);
        return  c;
    }

}
