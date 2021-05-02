package com.capgemini.project.microservice_passenger.models;

public class PassengerConfermation {
    private String pname;
    private String seatno;
    private String conf;
    public PassengerConfermation() {
    }
    public PassengerConfermation(String pname, String seatno, String conf) {
        this.pname = pname;
        this.seatno = seatno;
        this.conf = conf;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getSeatno() {
        return seatno;
    }
    public void setSeatno(String seatno) {
        this.seatno = seatno;
    }
    @Override
    public String toString() {
        return "PassengerConfermation [conf=" + conf + ", pname=" + pname + ", seatno=" + seatno + "]";
    }
    public String getConf() {
        return conf;
    }
    public void setConf(String conf) {
        this.conf = conf;
    }
}
