package com.capgemini.project.micreservice_train.model;

public class Stationno {
    private String s;
    private String sn;
    public Stationno() {
    }
    public Stationno(String s, String sn) {
        this.s = s;
        this.sn = sn;
    }
    public String getS() {
        return s;
    }
    public void setS(String s) {
        this.s = s;
    }
    public String getSn() {
        return sn;
    }
    public void setSn(String sn) {
        this.sn = sn;
    }
    @Override
    public String toString() {
        return "Stationno [s=" + s + ", sn=" + sn + "]";
    }
}
