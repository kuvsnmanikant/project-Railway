package com.capgemini.project.micreservice_train.model;

public class SearchDetails {
    
    private String train_no;
    private String train_name;
    private String train_type;
    private String train_start;
    private String train_end;
    private String coach_type;
    private String s1;
    private String s2;
    private String s1_name;
    private String s2_name;
    private String s1_arival;
    private String s1_departure;
    private String s1_date;
    private String s2_date;
    private String s2_arival;
    private String s2_departure;
    private int sl_seats;
    private int ac_seats;
    private int distance;
    private String price;

    public SearchDetails() {
    }

    public String getTrain_no() {
        return train_no;
    }
    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }
    public String getTrain_name() {
        return train_name;
    }
    public String getCoach_type() {
        return coach_type;
    }

    public void setCoach_type(String coach_type) {
        this.coach_type = coach_type;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }
    public String getTrain_type() {
        return train_type;
    }
    public void setTrain_type(String train_type) {
        this.train_type = train_type;
    }
    public String getS1() {
        return s1;
    }
    public void setS1(String s1) {
        this.s1 = s1;
    }
    public String getS2() {
        return s2;
    }
    public void setS2(String s2) {
        this.s2 = s2;
    }
    public String getS1_name() {
        return s1_name;
    }
    public void setS1_name(String s1_name) {
        this.s1_name = s1_name;
    }
    public String getS2_name() {
        return s2_name;
    }
    public void setS2_name(String s2_name) {
        this.s2_name = s2_name;
    }
    public String getS1_arival() {
        return s1_arival;
    }
    public void setS1_arival(String s1_arival) {
        this.s1_arival = s1_arival;
    }
    public String getS1_departure() {
        return s1_departure;
    }
    public void setS1_departure(String s1_departure) {
        this.s1_departure = s1_departure;
    }
    public String getS1_date() {
        return s1_date;
    }
    public void setS1_date(String s1_date) {
        this.s1_date = s1_date;
    }
    public String getS2_date() {
        return s2_date;
    }
    public void setS2_date(String s2_date) {
        this.s2_date = s2_date;
    }
    public String getS2_arival() {
        return s2_arival;
    }
    public void setS2_arival(String s2_arival) {
        this.s2_arival = s2_arival;
    }
    public String getS2_departure() {
        return s2_departure;
    }
    public void setS2_departure(String s2_departure) {
        this.s2_departure = s2_departure;
    }
    public int getSl_seats() {
        return sl_seats;
    }
    public void setSl_seats(int sl_seats) {
        this.sl_seats = sl_seats;
    }
    public int getAc_seats() {
        return ac_seats;
    }
    public void setAc_seats(int ac_seats) {
        this.ac_seats = ac_seats;
    }
    public int getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
   
    public String getTrain_start() {
        return train_start;
    }

    public void setTrain_start(String train_start) {
        this.train_start = train_start;
    }

    public String getTrain_end() {
        return train_end;
    }

    public void setTrain_end(String train_end) {
        this.train_end = train_end;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SearchDetails(String train_no, String train_name, String train_type, String train_start, String train_end,
            String coach_type, String s1, String s2, String s1_name, String s2_name, String s1_arival,
            String s1_departure, String s1_date, String s2_date, String s2_arival, String s2_departure, int sl_seats,
            int ac_seats, int distance, String price) {
        this.train_no = train_no;
        this.train_name = train_name;
        this.train_type = train_type;
        this.train_start = train_start;
        this.train_end = train_end;
        this.coach_type = coach_type;
        this.s1 = s1;
        this.s2 = s2;
        this.s1_name = s1_name;
        this.s2_name = s2_name;
        this.s1_arival = s1_arival;
        this.s1_departure = s1_departure;
        this.s1_date = s1_date;
        this.s2_date = s2_date;
        this.s2_arival = s2_arival;
        this.s2_departure = s2_departure;
        this.sl_seats = sl_seats;
        this.ac_seats = ac_seats;
        this.distance = distance;
        this.price = price;
    }

    @Override
    public String toString() {
        return "SearchDetails [ac_seats=" + ac_seats + ", coach_type=" + coach_type + ", distance=" + distance
                + ", price=" + price + ", s1=" + s1 + ", s1_arival=" + s1_arival + ", s1_date=" + s1_date
                + ", s1_departure=" + s1_departure + ", s1_name=" + s1_name + ", s2=" + s2 + ", s2_arival=" + s2_arival
                + ", s2_date=" + s2_date + ", s2_departure=" + s2_departure + ", s2_name=" + s2_name + ", sl_seats="
                + sl_seats + ", train_end=" + train_end + ", train_name=" + train_name + ", train_no=" + train_no
                + ", train_start=" + train_start + ", train_type=" + train_type + "]";
    }

   
    
}

