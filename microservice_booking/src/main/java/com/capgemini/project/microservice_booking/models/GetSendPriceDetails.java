package com.capgemini.project.microservice_booking.models;

public class GetSendPriceDetails {
    private String train_type;
    private String coach_type;
    private String food_type;
    public GetSendPriceDetails() {
    }
    public String getTrain_type() {
        return train_type;
    }
    public void setTrain_type(String train_type) {
        this.train_type = train_type;
    }
    public String getCoach_type() {
        return coach_type;
    }
    public String getFood_type() {
        return food_type;
    }
    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }
    public void setCoach_type(String coach_type) {
        this.coach_type = coach_type;
    }
    public GetSendPriceDetails(String train_type, String coach_type, String food_type) {
        this.train_type = train_type;
        this.coach_type = coach_type;
        this.food_type = food_type;
    }
    @Override
    public String toString() {
        return "GetSendPriceDetails [coach_type=" + coach_type + ", food_type=" + food_type + ", train_type="
                + train_type + "]";
    }
   
    
}
