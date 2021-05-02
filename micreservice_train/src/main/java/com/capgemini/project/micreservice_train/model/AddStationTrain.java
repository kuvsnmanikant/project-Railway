package com.capgemini.project.micreservice_train.model;

public class AddStationTrain {
    private String id;
    private String station_id;
    private String train_day;
    private String train_arrival;
    private String train_depat;
    private int distance;
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public AddStationTrain() {
    }
   
    public String getStation_id() {
        return station_id;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }
    public String getTrain_day() {
        return train_day;
    }
    public void setTrain_day(String train_day) {
        this.train_day = train_day;
    }
    public String getTrain_arrival() {
        return train_arrival;
    }
    public void setTrain_arrival(String train_arrival) {
        this.train_arrival = train_arrival;
    }
    public String getTrain_depat() {
        return train_depat;
    }
    public void setTrain_depat(String train_depat) {
        this.train_depat = train_depat;
    }
    public AddStationTrain(String id, String station_id, String train_day, String train_arrival, String train_depat,
            int distance) {
        this.id = id;
        this.station_id = station_id;
        this.train_day = train_day;
        this.train_arrival = train_arrival;
        this.train_depat = train_depat;
        this.distance = distance;
    }
    @Override
    public String toString() {
        return "AddStationTrain [distance=" + distance + ", id=" + id + ", station_id=" + station_id
                + ", train_arrival=" + train_arrival + ", train_day=" + train_day + ", train_depat=" + train_depat
                + "]";
    }
  
}
