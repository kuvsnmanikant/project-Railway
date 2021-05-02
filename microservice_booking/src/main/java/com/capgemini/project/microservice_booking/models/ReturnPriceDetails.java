package com.capgemini.project.microservice_booking.models;

import java.util.List;

public class ReturnPriceDetails {
    private String gst;
    private String total;
    private List<PassengerPrice> pp;
    public ReturnPriceDetails() {
    }
    public ReturnPriceDetails(String gst, String total, List<PassengerPrice> pp) {
        this.gst = gst;
        this.total = total;
        this.pp = pp;
    }
    public String getGst() {
        return gst;
    }
    public void setGst(String gst) {
        this.gst = gst;
    }
    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }
    public List<PassengerPrice> getPp() {
        return pp;
    }
    public void setPp(List<PassengerPrice> pp) {
        this.pp = pp;
    }
    @Override
    public String toString() {
        return "ReturnPriceDetails [gst=" + gst + ", pp=" + pp + ", total=" + total + "]";
    }
}
