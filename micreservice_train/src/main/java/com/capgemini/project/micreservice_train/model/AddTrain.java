package com.capgemini.project.micreservice_train.model;

import java.util.List;

public class AddTrain {
    private Train trains;
    public List<AddStationTrain> addstation;
    public AddTrain() {
    }
    public AddTrain(Train train, List<AddStationTrain> addstation) {
        this.trains = train;
        this.addstation = addstation;
    }
    public Train getTrain() {
        return trains;
    }
    public void setTrain(Train train) {
        this.trains = train;
    }
    public List<AddStationTrain> getAddstation() {
        return addstation;
    }
    public void setAddstation(List<AddStationTrain> addstation) {
        this.addstation = addstation;
    }
    @Override
    public String toString() {
        return "AddTrain [addstation=" + addstation + ", train=" + trains + "]";
    }
    
}
