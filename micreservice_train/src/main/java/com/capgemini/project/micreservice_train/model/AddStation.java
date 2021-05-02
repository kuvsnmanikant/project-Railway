package com.capgemini.project.micreservice_train.model;

import java.util.List;

public class AddStation {
    private String id;
    private String station_id;
    private String station_name;
    private List<Train_list1> station_list;
    public AddStation() {
    }
    public AddStation(String id, String station_id, String station_name, List<Train_list1> station_list) {
        this.id = id;
        this.station_id = station_id;
        this.station_name = station_name;
        this.station_list = station_list;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getStation_id() {
        return station_id;
    }
    @Override
    public String toString() {
        return "AddStation [id=" + id + ", station_id=" + station_id + ", station_list=" + station_list
                + ", station_name=" + station_name + "]";
    }
    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }
    public String getStation_name() {
        return station_name;
    }
    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }
    public List<Train_list1> getStation_list() {
        return station_list;
    }
    public void setStation_list(List<Train_list1> station_list) {
        this.station_list = station_list;
    }
}
