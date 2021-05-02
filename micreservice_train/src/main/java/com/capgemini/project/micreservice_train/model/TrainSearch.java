package com.capgemini.project.micreservice_train.model;

public class TrainSearch {

    private String s1;
    private String s2;
    private String d;
    private String c;
    private String g;

    public TrainSearch() {
    }

    public TrainSearch(String s1, String s2, String d, String c, String g) {
        this.s1 = s1;
        this.s2 = s2;
        this.d = d;
        this.c = c;
        this.g = g;
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

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    @Override
    public String toString() {
        return "TrainSearch [c=" + c + ", d=" + d + ", g=" + g + ", s1=" + s1 + ", s2=" + s2 + "]";
    }
}
