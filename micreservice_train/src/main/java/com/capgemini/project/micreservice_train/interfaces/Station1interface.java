package com.capgemini.project.micreservice_train.interfaces;

import java.util.List;
import com.capgemini.project.micreservice_train.model.Station;

// this interface is implemented on station service
public interface Station1interface {
    public List<Station> getAllStation();
    public Station getAllS(String id);
    public  Station getStation(String id);
    public String addStation(Station t);
    public String deleteStation(String id);
    public String updateStation(Station t, String s);
    public Station findByDay(String station_id,String day);
}
