package com.capgemini.project.micreservice_train.model;

import java.util.List;

public class TrainTimeTable {

    private String train_no;
    private String train_name;
    private String train_type;
    private List<TrainStation> staiontrain;
    public TrainTimeTable() {
    }
    public TrainTimeTable(String train_no, String train_name, String train_type, List<TrainStation> staiontrain) {
        this.train_no = train_no;
        this.train_name = train_name;
        this.train_type = train_type;
        this.staiontrain = staiontrain;
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
    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }
    public String getTrain_type() {
        return train_type;
    }
    public void setTrain_type(String train_type) {
        this.train_type = train_type;
    }
    public List<TrainStation> getStaiontrain() {
        return staiontrain;
    }
    public void setStaiontrain(List<TrainStation> staiontrain) {
        this.staiontrain = staiontrain;
    }
    @Override
    public String toString() {
        return "TrainTimeTable [staiontrain=" + staiontrain + ", train_name=" + train_name + ", train_no=" + train_no
                + ", train_type=" + train_type + "]";
    }
}
