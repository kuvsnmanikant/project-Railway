package com.capgemini.project.micreservice_train.model;

public class TrainNo {

    private String trainno;
    private String trainname;
    public TrainNo() {
    }
    public TrainNo(String trainno, String trainname) {
        this.trainno = trainno;
        this.trainname = trainname;
    }
    public String getTrainno() {
        return trainno;
    }
    public void setTrainno(String trainno) {
        this.trainno = trainno;
    }
    public String getTrainname() {
        return trainname;
    }
    public void setTrainname(String trainname) {
        this.trainname = trainname;
    }
    @Override
    public String toString() {
        return "TrainNo [trainname=" + trainname + ", trainno=" + trainno + "]";
    }
}
