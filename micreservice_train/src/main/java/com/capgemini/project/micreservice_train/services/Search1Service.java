package com.capgemini.project.micreservice_train.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
import com.capgemini.project.micreservice_train.exceptionhandlings.Notfoundexception;
import com.capgemini.project.micreservice_train.interfaces.Search1interface;
import com.capgemini.project.micreservice_train.model.AddStation;
import com.capgemini.project.micreservice_train.model.AddStationTrain;
import com.capgemini.project.micreservice_train.model.AddTrain;
import com.capgemini.project.micreservice_train.model.SearchDetails;
import com.capgemini.project.micreservice_train.model.Station;
import com.capgemini.project.micreservice_train.model.Stationno;
import com.capgemini.project.micreservice_train.model.Train;
import com.capgemini.project.micreservice_train.model.TrainNo;
import com.capgemini.project.micreservice_train.model.TrainSearch;
import com.capgemini.project.micreservice_train.model.TrainStation;
import com.capgemini.project.micreservice_train.model.TrainTimeTable;
import com.capgemini.project.micreservice_train.model.Train_list;
import com.capgemini.project.micreservice_train.model.Train_list1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Search1Service implements Search1interface {

    // here we are creating the instance for Station1services
    @Autowired
    private Station1services ts;

    // here we are creating the instance for Train1services
    @Autowired
    private Train1services ss;

    // this method is used to find the day by taking date as input
    public String dayofweek(int d, int m, int y) {
        int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
        y -= (m < 3) ? 1 : 0;
        String ar[] = { "sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday" };
        int a = (y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7;
        return ar[a];
    }

    // find the certain train details by taking the train list from the station
    // class and train number
    public String[] findTime(List<Train_list> tl, String s) {
        String[] a = new String[3];
        for (Train_list mode : tl) {
            if (s.equals(mode.getTrain_id())) {
                a[0] = mode.getTrain_arivel();
                a[1] = mode.getTrain_departure();
                a[2] = mode.getTrain_day();
            }
        }
        return a;
    }

    // to find the date of the train by taking the "a" as date of search and "b" as
    // day
    public String findDate(String a, String b, int ccc) {
        String aaa = "";
        String newDate = b;
        String oldDate = b;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(oldDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int[] iar = Arrays.stream(b.split("-")).mapToInt(Integer::parseInt).toArray();
        aaa = dayofweek(iar[0], iar[1], iar[2]);
        while (!a.equals(aaa)) {
            c.add(Calendar.DAY_OF_MONTH, ccc);
            newDate = sdf.format(c.getTime());
            int[] ia = Arrays.stream(newDate.split("-")).mapToInt(Integer::parseInt).toArray();
            aaa = dayofweek(ia[0], ia[1], ia[2]);
        }
        return newDate;
    }

    // add all the seats in all coatches
    public int findSum(List<Integer> s) {
        int sum = 0;
        for (int i : s) {
            sum += i;
        }
        return sum;
    }

    // this is the core method to find the certain train form given station1 to
    // station2
    public List<SearchDetails> ge(TrainSearch tr) {

        // converting date string to integer by using split
        int[] iar = Arrays.stream(tr.getD().split("-")).mapToInt(Integer::parseInt).toArray();

        // calling the dayofweek to find the day
        String a = dayofweek(iar[0], iar[1], iar[2]);

        List<Train_list> tl = new ArrayList<>();
        List<String> tns = new ArrayList<>();

        // finding the list of train by usinf station number and day
        Station st = ts.findByDay(tr.getS1(), a);
        for (Train_list mode : st.getStation_list()) {
            if (a.equals(mode.getTrain_day())) {
                tl.add(mode);
                tns.add(mode.getTrain_id());
            }
        }

        List<Train_list> tl1 = new ArrayList<>();
        List<String> tns1 = new ArrayList<>();

        // finding the list of trains passing throug the station2
        Station st1 = ts.getStation(tr.getS2());
        for (Train_list mode : st1.getStation_list()) {
            tl1.add(mode);
            tns1.add(mode.getTrain_id());
        }

        // filtering the list of trains by comparing the train lists from station1 and
        // staion2
        List<String> tns3 = new ArrayList<>();
        for (String mode : tns) {
            if (tns1.contains(mode)) {
                tns3.add(mode);
            }
        }

        // cleaning unwanted lists
        tns.clear();
        tns1.clear();
        List<Train> t = new ArrayList<>();

        // again filtering the train list by checking the coatch type and adding them to
        // list "t"
        for (String mode : tns3) {
            Train tt;
            if (tr.getC().equalsIgnoreCase("ALL")) {
                tt = ss.getAllT(mode);
            } else if (tr.getC().equalsIgnoreCase("AC")) {
                tt = ss.findByNoType(mode, "SL");
            } else {
                tt = ss.findByNoType(mode, "AC");
            }

            if (tt != null && (tt.getStations().indexOf(tr.getS1()) < tt.getStations().indexOf(tr.getS2()))) {
                t.add(tt);
            }
        }

        // if list "t" is empty then return null
        if (t.size() == 0) {
            return null;
        }

        // creating the new list to send the wanted train list to the customer
        List<SearchDetails> sd = new ArrayList<>();
        for (Train mode : t) {
            SearchDetails x = new SearchDetails();
            x.setTrain_no(mode.getTrain_id());
            x.setTrain_name(mode.getDetails().getTrain_name());
            x.setTrain_type(mode.getDetails().getTrain_type());
            x.setS1(tr.getS1()+"-"+mode.getStations().indexOf(tr.getS1()));
            x.setS2(tr.getS2()+"-"+mode.getStations().indexOf(tr.getS2()));
            x.setS1_name(st.getStation_name());
            x.setS2_name(st1.getStation_name());

            // here we are finding the train arrival and depature timings form the station1
            // using the findTime method
            String[] aaa = findTime(st.getStation_list(), mode.getTrain_id());
            x.setS1_arival(aaa[0]);
            x.setS1_departure(aaa[1]);
            // here we are finding the train arrival and depature timings form the station2
            // using the findTime method
            aaa = findTime(st1.getStation_list(), mode.getTrain_id());
            x.setS2_arival(aaa[0]);
            x.setS2_departure(aaa[1]);
            x.setS1_date(tr.getD());

            // calculating the date of the train arrivng the station2
            x.setS2_date(findDate(aaa[2], tr.getD(), 1));
            x.setTrain_start(findDate(mode.getTrain_fistday(), tr.getD(), -1));
            x.setTrain_end(findDate(mode.getTrain_lastday(), tr.getD(), 1));
            x.setCoach_type(tr.getC());

            // calculating the total number of seats in sleeper class
            x.setSl_seats(findSum(mode.getDetails().getSeat().getSl().getCoach()));
            // calculating the total number of seats in Ac class
            x.setAc_seats(findSum(mode.getDetails().getSeat().getAc().getCoach()));

            // calculating the distance by index of the stations in the station list and
            // subtacting the certain index value from the distance list
            int e = mode.getStations().indexOf(tr.getS1());
            int f = mode.getStations().indexOf(tr.getS2());
            x.setDistance(mode.getDetails().getDistance().get(f) - mode.getDetails().getDistance().get(e));
            x.setPrice("-");
            // adding the train details to the list
            sd.add(x);

        }

        // cleaning the data
        t.clear();
        tl.clear();
        tl1.clear();
    
        return sd;
    }

    // this will return the list containing index0: first date of the train index1:
    // string of stations index2: String of coaches staring date by id
    public List<String> getTrainStartingDate(String i, String d, String coach) {
        Train t = ss.getAllT(i);
        if (t == null) {
            try {
                throw new Notfoundexception(" not exist");
            } catch (Notfoundexception e) {
                e.printStackTrace();
            }
        }
        List<String> l = new ArrayList<>();
        l.add(findDate(t.getTrain_fistday(), d, -1));
        String a = "";
        for (String f : t.getStations()) {
            a += f;
            a += "-";
        }
        l.add(a);
        a = "";
        if (coach.equals("AC")) {
            for (Integer f : t.getDetails().getSeat().getAc().getCoach()) {
                a += String.valueOf(f);
                a += "-";
            }
        } else {
            for (Integer f : t.getDetails().getSeat().getSl().getCoach()) {
                a += String.valueOf(f);
                a += "-";
            }
        }
        l.add(a);
        
        return l;
    }


    // it will return the list of Stationno having the properties station name and station number
    public List<Stationno> getstationlist() {
        List<Station> s= ts.getAllStation();
        List<Stationno> sn= new ArrayList<>();
        for (Station stat:s){
            sn.add(new Stationno(stat.getStation_name(),stat.getStation_id()));
        }
        s.clear();
        return sn;
    }

    // it will return the list of TrainNo having the properties train name and number
    public List<TrainNo> getTrainlist() {
        List<Train> t= ss.getAllTrains();
        List<TrainNo> tn= new ArrayList<>();
        for(Train tt:t){
            tn.add(new TrainNo(tt.getTrain_id(),tt.getDetails().getTrain_name()));
        }
        t.clear();
        return tn;
    }

    // it will return the train time table 
    public TrainTimeTable getTrainTimeTable(String id) {
        Train t= ss.getAllT(id);
        TrainTimeTable ttt= new TrainTimeTable();

        ttt.setTrain_no(t.getTrain_id());
        ttt.setTrain_name(t.getDetails().getTrain_name());
        ttt.setTrain_type(t.getDetails().getTrain_type());
        List<TrainStation> trainsta= new ArrayList<>();
        for(String s:t.getStations()){
            Station sta= ts.getStation(s);
            TrainStation trains= new TrainStation();
            trains.setStation_id(sta.getStation_id());
            trains.setStation_name(sta.getStation_name());
            for(Train_list tl:sta.getStation_list()){
                if(tl.getTrain_id().equals(t.getTrain_id())){
                    trains.setStation_train_arrival(tl.getTrain_arivel());
                    trains.setStation_train_day(tl.getTrain_day());
                    trains.setStation_train_depat(tl.getTrain_departure());
                }
            }
           
            trainsta.add(trains);
        }
        
        ttt.setStaiontrain(trainsta);
        // System.out.println(ttt);
        // // t=null;
        // trainsta.clear();
        return ttt;
    }

    // it will the new tarain details and update the station data base
    public String addTrain(AddTrain at) {
        List<String> l= new ArrayList<>();
        List<Integer> i= new ArrayList<>();
        for (AddStationTrain s: at.getAddstation()){
            // l.add(s.getStation_id());
            // i.add(s.getDistance());
            Train_list tl= new Train_list();
            tl.setTrain_id(at.getTrain().getTrain_id());
            tl.setTrain_day(s.getTrain_day());
            tl.setTrain_arivel(s.getTrain_arrival());
            tl.setTrain_departure(s.getTrain_depat());
            String str=ts.updateStationTraindetails(tl, s.getStation_id());
            if(!str.equals("success")){
                return "faild";
            }
        }
        // at.getTrain().setStations(l);
        // at.getTrain().getDetails().setDistance(i);
        String tra= ss.addTrain(at.getTrain());
        if(!tra.equals("Success")){
            return "faild";
        }
        l.clear();
        i.clear();
        return "success";
    }

    //  delete the train details and update the  station collection
    public String deleteTrain(String id){
        Train s=ss.getAllT(id);
        List<String> sta=s.getStations();
        for(String ss:sta){
            Station a=ts.getStation(ss);
            List<Train_list> tl=a.getStation_list();
            for(Train_list t:tl){
                if(t.getTrain_id().equals(id)){
                    tl.remove(t);
                }
            }
            a.setStation_list(tl);
            String str=ts.updateStation(a,ss);
            if(!str.equals("success")){
                return "faild";
            }
        }
     
        String strs=ss.deleteTrain(id);
        return strs;
    }

    // it will delte the staion and update the train collection
    public String deleteStation(String id){
        Station s= ts.getStation(id);
        List<Train_list> tl = s.getStation_list();
        for (Train_list t:tl){
            Train tr= ss.getAllT(t.getTrain_id());
            List<String> str= tr.getStations();
            for(String aa:str){
                if(aa.equals(id)){
                    str.remove(aa);
                }
            }
            tr.setStations(str);
            String sss=ss.updateTrain(tr, tr.getTrain_id());
            if(!sss.equals("success")){
                return "faild";
            }
        }
      String string= ts.deleteStation(id);
      return string;
    }

// it will add new station and update the train data base
    public String addStation(AddStation s){
        List<Train_list1> tl= s.getStation_list();
        List<Train_list> t= new ArrayList<>();

        for(Train_list1 a:tl){
            Train train= ss.getAllT(a.getTrain_id());
            List<String> str= train.getStations();
            List<Integer> distance= train.getDetails().getDistance();
            for(Integer i:distance){
                if(i>a.getTrain_distance()){
                    int index= distance.indexOf(i);
                    distance.add(index,a.getTrain_distance());
                    str.add(index,s.getStation_id());
                    break;
                }
            }
            train.setStations(str);
            train.getDetails().setDistance(distance);
            String sss= ss.updateTrain(train, train.getTrain_id());
            if(!sss.equals("success")){
                return "faild";
            }
        }
        Station station= new Station();
        station.setId(s.getId());
        station.setStation_id(s.getStation_id());
        station.setStation_name(s.getStation_name());
        for(Train_list1 a:tl){
            Train_list trainl= new Train_list();
            trainl.setTrain_id(a.getTrain_id());
            trainl.setTrain_day(a.getTrain_day());
            trainl.setTrain_arivel(a.getTrain_arivel());
            trainl.setTrain_departure(a.getTrain_departure());
            t.add(trainl);
        }
        station.setStation_list(t);
        String strr= ts.addStation(station);

        return strr;
    }

    // it will update the existing station details in the station collection
    public String updateStation(AddStation s){
        List<Train_list1> tl= s.getStation_list();
        List<Train_list> t= new ArrayList<>();

        for(Train_list1 a:tl){
            Train train= ss.getAllT(a.getTrain_id());
            List<String> str= train.getStations();
            List<Integer> distance= train.getDetails().getDistance();
            for(Integer i:distance){
                if(i>a.getTrain_distance()){
                    int index= distance.indexOf(i);
                    distance.add(index,a.getTrain_distance());
                    str.add(index,s.getStation_id());
                    break;
                }
            }
            train.setStations(str);
            train.getDetails().setDistance(distance);
            String sss= ss.updateTrain(train, train.getTrain_id());
            if(!sss.equals("success")){
                return "faild";
            }
        }
        Station station= new Station();
        station.setId(s.getId());
        station.setStation_id(s.getStation_id());
        station.setStation_name(s.getStation_name());
        for(Train_list1 a:tl){
            Train_list trainl= new Train_list();
            trainl.setTrain_id(a.getTrain_id());
            trainl.setTrain_day(a.getTrain_day());
            trainl.setTrain_arivel(a.getTrain_arivel());
            trainl.setTrain_departure(a.getTrain_departure());
            t.add(trainl);
        }
        station.setStation_list(t);
        String strr= ts.updateStation(station,station.getStation_id());

        return strr;
    }
}
