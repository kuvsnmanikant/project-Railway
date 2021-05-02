package com.capgemini.project.micreservice_train.model;

public class TrainStation {
    private String station_name;
    private String station_id;
    private String station_train_day;
    private String station_train_arrival;
    private String station_train_depat;
    public TrainStation() {
    }
    public TrainStation(String station_name, String station_id, String station_train_day, String station_train_arrival,
            String station_train_depat) {
        this.station_name = station_name;
        this.station_id = station_id;
        this.station_train_day = station_train_day;
        this.station_train_arrival = station_train_arrival;
        this.station_train_depat = station_train_depat;
    }
    public String getStation_name() {
        return station_name;
    }
    @Override
    public String toString() {
        return "TrainStation [station_id=" + station_id + ", station_name=" + station_name + ", station_train_arrival="
                + station_train_arrival + ", station_train_day=" + station_train_day + ", station_train_depat="
                + station_train_depat + "]";
    }
    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }
    public String getStation_id() {
        return station_id;
    }
    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }
    public String getStation_train_day() {
        return station_train_day;
    }
    public void setStation_train_day(String station_train_day) {
        this.station_train_day = station_train_day;
    }
    public String getStation_train_arrival() {
        return station_train_arrival;
    }
    public void setStation_train_arrival(String station_train_arrival) {
        this.station_train_arrival = station_train_arrival;
    }
    public String getStation_train_depat() {
        return station_train_depat;
    }
    public void setStation_train_depat(String station_train_depat) {
        this.station_train_depat = station_train_depat;
    }
}
