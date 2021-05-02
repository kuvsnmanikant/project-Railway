package com.capgemini.project.microservice_booking.models;

import java.util.List;

public class GetPassengerData {

    private SearchDetails sd;
    private List<PassengerDetails> pd;
    private String booked_by;
    public String getBooked_by() {
        return booked_by;
    }
    public void setBooked_by(String booked_by) {
        this.booked_by = booked_by;
    }
    public GetPassengerData() {
    }
   
    public SearchDetails getSd() {
        return sd;
    }
    public void setSd(SearchDetails sd) {
        this.sd = sd;
    }
    public List<PassengerDetails> getPd() {
        return pd;
    }
    public void setPd(List<PassengerDetails> pd) {
        this.pd = pd;
    }
    public GetPassengerData(SearchDetails sd, List<PassengerDetails> pd, String booked_by) {
        this.sd = sd;
        this.pd = pd;
        this.booked_by = booked_by;
    }
    @Override
    public String toString() {
        return "GetPassengerData [booked_by=" + booked_by + ", pd=" + pd + ", sd=" + sd + "]";
    }
   
    
}
