package com.capgemini.project.microservice_booking.models;

public class SendPriceDetails {
   private double distance_price;
   private int food_price;
   private double insurance_price;
   private double gst_percentage;
   private double hadicap_percentage;
   private double sr_citizen_percentage;
public double getHadicap_percentage() {
    return hadicap_percentage;
}
public void setHadicap_percentage(double hadicap_percentage) {
    this.hadicap_percentage = hadicap_percentage;
}
public double getSr_citizen_percentage() {
    return sr_citizen_percentage;
}
public void setSr_citizen_percentage(double sr_citizen_percentage) {
    this.sr_citizen_percentage = sr_citizen_percentage;
}
public SendPriceDetails() {
}
public double getDistance_price() {
    return distance_price;
}
public void setDistance_price(double distance_price) {
    this.distance_price = distance_price;
}
public int getFood_price() {
    return food_price;
}
public void setFood_price(int food_price) {
    this.food_price = food_price;
}
public double getInsurance_price() {
    return insurance_price;
}
public void setInsurance_price(double insurance_price) {
    this.insurance_price = insurance_price;
}
public double getGst_percentage() {
    return gst_percentage;
}
public void setGst_percentage(double gst_percentage) {
    this.gst_percentage = gst_percentage;
}
public SendPriceDetails(double distance_price, int food_price, double insurance_price, double gst_percentage,
        double hadicap_percentage, double sr_citizen_percentage) {
    this.distance_price = distance_price;
    this.food_price = food_price;
    this.insurance_price = insurance_price;
    this.gst_percentage = gst_percentage;
    this.hadicap_percentage = hadicap_percentage;
    this.sr_citizen_percentage = sr_citizen_percentage;
}
@Override
public String toString() {
    return "SendPriceDetails [distance_price=" + distance_price + ", food_price=" + food_price + ", gst_percentage="
            + gst_percentage + ", hadicap_percentage=" + hadicap_percentage + ", insurance_price=" + insurance_price
            + ", sr_citizen_percentage=" + sr_citizen_percentage + "]";
}

    
}
