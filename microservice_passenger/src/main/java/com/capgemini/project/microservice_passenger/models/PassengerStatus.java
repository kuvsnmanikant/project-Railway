package com.capgemini.project.microservice_passenger.models;

import java.util.List;

public class PassengerStatus {
    private String trani_no;
    private  String train_name;
    private String from;
    private String to;
    private String journey_date;
    private String destination_date;
    private List<PassengerConfermation> pc;
    public PassengerStatus() {
    }
    public PassengerStatus(String trani_no, String train_name, String from, String to, String journey_date,
            String destination_date,
            List<PassengerConfermation> pc) {
        this.trani_no = trani_no;
        this.train_name = train_name;
        this.from = from;
        this.to = to;
        this.journey_date = journey_date;
        this.destination_date = destination_date;

        this.pc = pc;
    }
    public String getTrani_no() {
        return trani_no;
    }
    public void setTrani_no(String trani_no) {
        this.trani_no = trani_no;
    }
    public String getTrain_name() {
        return train_name;
    }
    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getJourney_date() {
        return journey_date;
    }
    public void setJourney_date(String journey_date) {
        this.journey_date = journey_date;
    }
    public String getDestination_date() {
        return destination_date;
    }
    public void setDestination_date(String destination_date) {
        this.destination_date = destination_date;
    }
   
    public List<PassengerConfermation> getPc() {
        return pc;
    }
    public void setPc(List<PassengerConfermation> pc) {
        this.pc = pc;
    }
    @Override
    public String toString() {
        return "PassengerStatus [arrival_time=" 
                + ", destination_date=" + destination_date + ", from=" + from + ", journey_date=" + journey_date
                + ", pc=" + pc + ", to=" + to + ", train_name="
                + train_name + ", trani_no=" + trani_no + "]";
    }
    public PassengerStatus getStatus(String pnr) {
        return null;
    }
    
}
