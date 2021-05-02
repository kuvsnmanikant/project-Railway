package com.capgemini.project.microservice_booking.models;
import java.util.List;
public class ListOfStationsAndCoaches {
    private List<String> stations;
    private List<Integer> coaches;
    public ListOfStationsAndCoaches() {
    }
    public ListOfStationsAndCoaches(List<String> stations, List<Integer> coaches) {
        this.stations = stations;
        this.coaches = coaches;
    }
    public List<String> getStations() {
        return stations;
    }
    public void setStations(List<String> stations) {
        this.stations = stations;
    }
    public List<Integer> getCoaches() {
        return coaches;
    }
    public void setCoaches(List<Integer> coaches) {
        this.coaches = coaches;
    }
    @Override
    public String toString() {
        return "ListOfStationsAndCoaches [coaches=" + coaches + ", stations=" + stations + "]";
    }
}
