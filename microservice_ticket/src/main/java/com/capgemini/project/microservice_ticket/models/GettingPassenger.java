package com.capgemini.project.microservice_ticket.models;

public class GettingPassenger {
    private String trainno;
    private String date;
    private int a;
    private int b;
    public GettingPassenger() {
    }
    public GettingPassenger(String trainno, String date, int a, int b) {
        this.trainno = trainno;
        this.date = date;
        this.a = a;
        this.b = b;
    }
    public String getTrainno() {
        return trainno;
    }
    public void setTrainno(String trainno) {
        this.trainno = trainno;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }
    @Override
    public String toString() {
        return "GettingPassenger [a=" + a + ", b=" + b + ", date=" + date + ", trainno=" + trainno + "]";
    }
}
