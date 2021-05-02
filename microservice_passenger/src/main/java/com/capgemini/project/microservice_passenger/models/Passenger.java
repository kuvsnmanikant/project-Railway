package com.capgemini.project.microservice_passenger.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// this class will tell about the arctectur of the data in the database
@Document(collection="Passenger")
public class Passenger {
    @Id
    private String id;
    private String p_name;
    private String p_gender;
    private int p_age;
    private String p_handicap;
    private String pnr_no;
    private String p_trainno;
    private String p_trainname;
    private String j_edate;
    private String j_date;
    private String ts_date;
    private String te_date;
    private String food;
    private String start;
    private String destination;
    private int start_index;
    private int destination_index;
    private String seat_no;
    private String booked_by;
    private String r_status;
    public Passenger() {
    }
   
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getP_name() {
        return p_name;
    }
    public void setP_name(String p_name) {
        this.p_name = p_name;
    }
    public String getP_gender() {
        return p_gender;
    }
    public void setP_gender(String p_gender) {
        this.p_gender = p_gender;
    }
    public int getP_age() {
        return p_age;
    }
    public void setP_age(int p_age) {
        this.p_age = p_age;
    }
    public void setP_handicap(String p_handicap) {
        this.p_handicap = p_handicap;
    }
    public String getPnr_no() {
        return pnr_no;
    }
    public void setPnr_no(String pnr_no) {
        this.pnr_no = pnr_no;
    }
    public String getP_trainno() {
        return p_trainno;
    }
    public void setP_trainno(String p_trainno) {
        this.p_trainno = p_trainno;
    }
 
    public String getJ_date() {
        return j_date;
    }
    public void setJ_date(String j_date) {
        this.j_date = j_date;
    }
    public String getFood() {
        return food;
    }
    public void setFood(String food) {
        this.food = food;
    }
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getSeat_no() {
        return seat_no;
    }
    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }
    public String getBooked_by() {
        return booked_by;
    }
    public void setBooked_by(String booked_by) {
        this.booked_by = booked_by;
    }
    public String getR_status() {
        return r_status;
    }
    public void setR_status(String r_status) {
        this.r_status = r_status;
    }
   
    public String getTs_date() {
        return ts_date;
    }
    public void setTs_date(String ts_date) {
        this.ts_date = ts_date;
    }
    public String getTe_date() {
        return te_date;
    }
    public void setTe_date(String te_date) {
        this.te_date = te_date;
    }

    public String getP_trainname() {
        return p_trainname;
    }

    public void setP_trainname(String p_trainname) {
        this.p_trainname = p_trainname;
    }

    public String getP_handicap() {
        return p_handicap;
    }

    public String getJ_edate() {
        return j_edate;
    }

    public void setJ_edate(String j_edate) {
        this.j_edate = j_edate;
    }

    public int getStart_index() {
        return start_index;
    }

    public void setStart_index(int start_index) {
        this.start_index = start_index;
    }

    public int getDestination_index() {
        return destination_index;
    }

    public void setDestination_index(int destination_index) {
        this.destination_index = destination_index;
    }

    public Passenger(String id, String p_name, String p_gender, int p_age, String p_handicap, String pnr_no,
            String p_trainno, String p_trainname, String j_edate, String j_date, String ts_date, String te_date,
            String food, String start, String destination, int start_index, int destination_index, String seat_no,
            String booked_by, String r_status) {
        this.id = id;
        this.p_name = p_name;
        this.p_gender = p_gender;
        this.p_age = p_age;
        this.p_handicap = p_handicap;
        this.pnr_no = pnr_no;
        this.p_trainno = p_trainno;
        this.p_trainname = p_trainname;
        this.j_edate = j_edate;
        this.j_date = j_date;
        this.ts_date = ts_date;
        this.te_date = te_date;
        this.food = food;
        this.start = start;
        this.destination = destination;
        this.start_index = start_index;
        this.destination_index = destination_index;
        this.seat_no = seat_no;
        this.booked_by = booked_by;
        this.r_status = r_status;
    }

    @Override
    public String toString() {
        return "Passenger [booked_by=" + booked_by + ", destination=" + destination + ", destination_index="
                + destination_index + ", food=" + food + ", id=" + id + ", j_date=" + j_date + ", j_edate=" + j_edate
                + ", p_age=" + p_age + ", p_gender=" + p_gender + ", p_handicap=" + p_handicap + ", p_name=" + p_name
                + ", p_trainname=" + p_trainname + ", p_trainno=" + p_trainno + ", pnr_no=" + pnr_no + ", r_status="
                + r_status + ", seat_no=" + seat_no + ", start=" + start + ", start_index=" + start_index + ", te_date="
                + te_date + ", ts_date=" + ts_date + "]";
    }

    
 

}
