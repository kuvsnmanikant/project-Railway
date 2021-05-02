package com.capgemini.project.micreservice_train;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import com.capgemini.project.micreservice_train.model.Station;
import com.capgemini.project.micreservice_train.model.Train_list;
import com.capgemini.project.micreservice_train.services.Station1services;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// this class will check the methods in the Station1Service
@RunWith(SpringRunner.class)
@SpringBootTest
public class StationTesting {

    // here we are creating instance of Station1services
    @Autowired
    private Station1services ss;

    // this will check weadhter the data is retreaving is correct or not
    @Test
    @DisplayName("getAllStation in Station1services  1")
    public void getUserTest1() {
        assertEquals(7, ss.getAllStation().size());
    }

    // this will checkwether it is returning the currect object or not by name of
    // the station
    @Test
    @DisplayName("getAllS in Station1services  1")
    public void getUserTest2() {
        Train_list t1 = new Train_list("102030", "wednesday", "-", "16:30:00");
        Train_list t2 = new Train_list("102031", "monday", "14:10:00", "-");
        Train_list t3 = new Train_list("102050", "friday", "-", "4:10:00");
        Train_list t4 = new Train_list("102051", "thursday", "21:00:00", "-");
        List<Train_list> l = Arrays.asList(t1, t2, t3, t4);
        Station s = new Station("2", "S0001", "Amritsar", l);
        assertTrue(s.equals(ss.getAllS("Amritsar")));
    }

    // this will check weadhter the data is retreaving is correct or not by checking
    // station id and trian day
    @Test
    @DisplayName("getAllStation in Station1services  1")
    public void getUserTest3() {
        Train_list t1 = new Train_list("102030", "wednesday", "-", "16:30:00");
        Train_list t2 = new Train_list("102031", "monday", "14:10:00", "-");
        Train_list t3 = new Train_list("102050", "friday", "-", "4:10:00");
        Train_list t4 = new Train_list("102051", "thursday", "21:00:00", "-");
        List<Train_list> l = Arrays.asList(t1, t2, t3, t4);
        Station s = new Station("2", "S0001", "Amritsar", l);
        assertTrue(s.equals(ss.findByDay("S0001", "monday")));
    }

    // checking wether the data is deleted or not
    @Test
    @DisplayName("deleteStation in Station1services  1")
    public void getUserTest4() {
        ss.deleteStation("S0001");
        assertEquals(6, ss.getAllStation().size());
    }

    // this will check wether the station is added or not
    @Test
    @DisplayName("addStation in Station1services  1")
    public void getUserTest5() {
        Train_list t1 = new Train_list("102030", "wednesday", "-", "16:30:00");
        Train_list t2 = new Train_list("102031", "monday", "14:10:00", "-");
        Train_list t3 = new Train_list("102050", "friday", "-", "4:10:00");
        Train_list t4 = new Train_list("102055", "thursday", "21:00:00", "-"); // changed data 102051 to 102055
        List<Train_list> l = Arrays.asList(t1, t2, t3, t4);
        Station s = new Station("2", "S0001", "Amritsar", l);
        ss.addStation(s);
        assertTrue(s.equals(ss.getAllS("Amritsar")));
    }

    // this will check wether the station is updated or not
    @Test
    @DisplayName("updateStation in Station1services  1")
    public void getUserTest6() {
        Train_list t1 = new Train_list("102030", "wednesday", "-", "16:30:00");
        Train_list t2 = new Train_list("102031", "monday", "14:10:00", "-");
        Train_list t3 = new Train_list("102050", "friday", "-", "4:10:00");
        Train_list t4 = new Train_list("102051", "thursday", "21:00:00", "-");
        List<Train_list> l = Arrays.asList(t1, t2, t3, t4);
        Station s = new Station("2", "S0001", "Amritsar", l);
        ss.updateStation(s, "S0001");
        assertTrue(s.equals(ss.getAllS("Amritsar")));
    }
}
