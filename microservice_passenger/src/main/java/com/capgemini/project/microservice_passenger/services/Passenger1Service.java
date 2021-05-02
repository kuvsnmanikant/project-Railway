package com.capgemini.project.microservice_passenger.services;

import java.util.ArrayList;
import java.util.List;
import com.capgemini.project.microservice_passenger.databases.Passenger1Database;
import com.capgemini.project.microservice_passenger.exceptionhandler.Notfoundexception;
import com.capgemini.project.microservice_passenger.interfaces.Passenger1Interface;
import com.capgemini.project.microservice_passenger.models.Passenger;
import com.capgemini.project.microservice_passenger.models.PassengerConfermation;
import com.capgemini.project.microservice_passenger.models.PassengerStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Passenger1Service implements Passenger1Interface {

    // here we are creating the instances to the Passenger1Database
    @Autowired
    private Passenger1Database pd;

    // it will return the all passengers details in the database
    public List<Passenger> getAllPassengers() {
        return pd.findAll();
    }

    // it will return the list of passengers by given pnr no.
    public List<Passenger> findByPnr(String o) {
        List<Passenger> a = pd.findByPnr(o);
        if (a.size() == 0) {
            try {
                throw new Notfoundexception(o + " not exist");
            } catch (Notfoundexception e) {
                System.err.println(e);
            }
        }
        return a;
    }

    public List<Passenger> findBybooked_by(String o) {
        List<Passenger> a = pd.findBybooked_by(o);
        if (a.size() == 0) {
            try {
                throw new Notfoundexception(o + " not exist");
            } catch (Notfoundexception e) {
                System.err.println(e);
            }
        }
        return a;
    }

    // thsi will update the existing data in the data base by pnr no.
    public String updatePassenger(Passenger p, String s) {
        List<Passenger> a = pd.findByPnr(s);
        if (a.size() == 0) {
            try {
                throw new Notfoundexception(s + " not exist");
            } catch (Notfoundexception e) {
                System.err.println(e);
            }
        }
        pd.deleteByPnr(s);
        pd.save(p);
        return "success";
    }

    // thsi will delete the existing data in the data base by pnr no.
    public String deletePassenger(String s) {
        List<Passenger> a = pd.findByPnr(s);
        if (a.size() == 0) {
            try {
                throw new Notfoundexception(s + " not exist");
            } catch (Notfoundexception e) {

                System.err.println(e);
            }
        }
        pd.deleteByPnr(s);
        return "success";
    }

    // it will add the new passenger data
    public String addPassenge(Passenger t) {
        List<Passenger> a = pd.findByPnr(t.getPnr_no());
        if (a.size() > 5) {
            return "you can't add";
        }
        pd.save(t);
        return "success";
    }

    // it will return the passenger details who booked the certain train in certain
    // date and filtering to book the ticket by indexes
    public List<Passenger> findBytrainnoDate(String p, String e, int q, int r) {
        List<Passenger> a = pd.findBytrainnoDate1(p, e);
        // List<Passenger> a = pd.findBytrainnoDate(p, e, r_status, si, di);
        if (a.size() == 0) {
            try {
                throw new Notfoundexception("not exist");
            } catch (Notfoundexception e1) {
                System.err.println(e1);
            }
        }
        List<Passenger> rr = new ArrayList<>();
        for (Passenger pp : a) {
            if (pp.getR_status().equals("cancelled") || (pp.getStart_index() >= r || pp.getDestination_index() <= q)) {
            } else {
                rr.add(pp);
            }
        }
        a.clear();
        return rr;
    }

    // this will update the status of the passenger to cancle on the base of pnr number
    public String cancelledPassenger(String pnr) {
        List<Passenger> a = pd.findByPnr(pnr);
        if (a.size() == 0) {
            try {
                throw new Notfoundexception(pnr + " not exist");
            } catch (Notfoundexception e) {
                System.err.println(e);
            }
        }
        pd.deleteByPnr(pnr);
        for(Passenger p: a){
            p.setR_status("cancelled");
            pd.save(p);
        }
        return "success";
    }

    // this will fetch the data from the data base on the pnr number and return it
    public PassengerStatus getStatus(String pnr){
        List<Passenger> a= pd.findByPnr(pnr);
        if (a.size() == 0) {
            try {
                throw new Notfoundexception(pnr + " not exist");
            } catch (Notfoundexception e) {
                System.err.println(e);
            }
        }
        PassengerStatus ps =new PassengerStatus();
        List<PassengerConfermation> pcc = new ArrayList<>();
        
        for(Passenger p:a){
            PassengerConfermation pc = new PassengerConfermation();
            ps.setTrani_no(p.getP_trainno());
            ps.setTrain_name(p.getP_trainname());
            ps.setFrom(p.getStart());
            ps.setTo(p.getDestination());
            ps.setJourney_date(p.getJ_date());
            ps.setDestination_date(p.getJ_edate());
           pc.setPname(p.getP_name());
           pc.setSeatno(p.getSeat_no());
           pc.setConf(p.getR_status());
           pcc.add(pc);
        }
        ps.setPc(pcc);
        
        return ps;
    }

    // it will return the pasenger list bsed onthe date and train number
    public List<Passenger> PassengerDataTrain(String t,String d){
        List<Passenger> a = pd.findBytrainnoDate1(t, d);
        if (a.size() == 0) {
            try {
                throw new Notfoundexception("not exist");
            } catch (Notfoundexception e1) {
                System.err.println(e1);
            }
        }
        return a;
    }

}
