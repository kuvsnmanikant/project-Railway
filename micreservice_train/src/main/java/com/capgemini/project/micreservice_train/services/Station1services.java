package com.capgemini.project.micreservice_train.services;

import java.util.List;
import com.capgemini.project.micreservice_train.database.StationDatabase;
import com.capgemini.project.micreservice_train.exceptionhandlings.Notfoundexception;
import com.capgemini.project.micreservice_train.interfaces.Station1interface;
import com.capgemini.project.micreservice_train.model.Station;
import com.capgemini.project.micreservice_train.model.Train_list;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Station1services implements Station1interface {

    // creating the instance to the StationDatabase repository
    @Autowired
    private StationDatabase tdb;

    // this will return the all the stations in the database
    @Override
    public List<Station> getAllStation() {
        return tdb.findAll();
    }

    // this will return the station details by staion name
    @Override
    public Station getAllS(String id) {
        Station a = tdb.findByName(id);
        if (a == null) {
            try {
                throw new Notfoundexception(id + " not exist");
            } catch (Notfoundexception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return a;
    }

    // this will return the station details by checking staion id and day
    @Override
    public Station findByDay(String station_id, String day) {
        Station a = tdb.findByDay(station_id, day);
        if (a == null) {
            try {
                throw new Notfoundexception(" not exist");
            } catch (Notfoundexception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return a;
    }

    // this will return the station details by staion id
    @Override
    public Station getStation(String id) {
        Station a = tdb.findByStationId(id);
        if (a == null) {
            try {
                throw new Notfoundexception(id + " not exist");
            } catch (Notfoundexception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return a;
    }

    // this will add the new station to the database
    @Override
    public String addStation(Station t) {
        Station a = tdb.findByStationId(t.getStation_id());
        if (a != null) {
            try {
                throw new Notfoundexception(t.getStation_id() + " already exist");
            } catch (Notfoundexception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        tdb.save(t);
        return "success";
    }

    // this will delete the station details by the station id
    @Override
    public String deleteStation(String id) {
        Station a = tdb.findByStationId(id);
        if (a == null) {
            try {
                throw new Notfoundexception(id + " not exist");
            } catch (Notfoundexception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        tdb.deleteByStationId(id);
        return "success";
    }

    // this will update the station details by staion id
    @Override
    public String updateStation(Station t, String s) {
        Station a = tdb.findByStationId(s);
        if (a == null) {
            try {
                throw new Notfoundexception(s + " not exist");
            } catch (Notfoundexception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        tdb.deleteByStationId(s);
        tdb.save(t);
        return "success";
    }

    public String updateStationTraindetails(Train_list tl, String station_id) {
        Station a = tdb.findByStationId(station_id);
        if (a == null) {
            try {
                throw new Notfoundexception(station_id + " not exist");
            } catch (Notfoundexception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        tdb.deleteByStationId(station_id);
        a.getStation_list().add(tl);
        tdb.save(a);
        return "success";
    }

}
