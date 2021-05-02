package com.capgemini.project.micreservice_train.model;

public class Train_list1 {
    private String train_id;
    private String train_day;
    private String train_arivel;
    private String train_departure;
    private int train_distance;
    public Train_list1() {
    }
    public Train_list1(String train_id, String train_day, String train_arivel, String train_departure,
            int train_distance) {
        this.train_id = train_id;
        this.train_day = train_day;
        this.train_arivel = train_arivel;
        this.train_departure = train_departure;
        this.train_distance = train_distance;
    }
    public String getTrain_id() {
        return train_id;
    }
    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }
    public String getTrain_day() {
        return train_day;
    }
    public void setTrain_day(String train_day) {
        this.train_day = train_day;
    }
    public String getTrain_arivel() {
        return train_arivel;
    }
    public void setTrain_arivel(String train_arivel) {
        this.train_arivel = train_arivel;
    }
    public String getTrain_departure() {
        return train_departure;
    }
    public void setTrain_departure(String train_departure) {
        this.train_departure = train_departure;
    }
    public int getTrain_distance() {
        return train_distance;
    }
    public void setTrain_distance(int train_distance) {
        this.train_distance = train_distance;
    }
    @Override
    public String toString() {
        return "Train_list1 [train_arivel=" + train_arivel + ", train_day=" + train_day + ", train_departure="
                + train_departure + ", train_distance=" + train_distance + ", train_id=" + train_id + "]";
    }
    
}
