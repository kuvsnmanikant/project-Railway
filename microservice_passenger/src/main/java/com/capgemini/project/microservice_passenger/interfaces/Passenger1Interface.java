package com.capgemini.project.microservice_passenger.interfaces;

import java.util.List;
import com.capgemini.project.microservice_passenger.models.Passenger;

// this will be implemented by the passenger1service 
public interface Passenger1Interface {

    public List<Passenger> getAllPassengers();

    public List<Passenger> findByPnr(String o);

    public List<Passenger> findBytrainnoDate(String p, String e,int q, int r);

    public String updatePassenger(Passenger p, String s);

    public String addPassenge(Passenger t);
}
