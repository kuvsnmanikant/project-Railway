package com.capgemini.project.microservice_booking.models;
import java.util.List;

public class PassengerConveter {
    private List<Passenger> p;

    public PassengerConveter() {
    }

    public PassengerConveter(List<Passenger> p) {
        this.p = p;
    }

    public List<Passenger> getP() {
        return p;
    }

    public void setP(List<Passenger> p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "PassengerConveter [p=" + p + "]";
    }
    
}

