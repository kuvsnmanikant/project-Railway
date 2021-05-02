package com.capgemini.project.microservice_booking.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Booking")
public class Booking {
    @Id
    private String id;
    @Indexed
    private String pnr;
    private ReturnPriceDetails rp;
    public Booking() {
    }
    public Booking(String id, String pnr, ReturnPriceDetails rp) {
        this.id = id;
        this.pnr = pnr;
        this.rp = rp;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPnr() {
        return pnr;
    }
    public void setPnr(String pnr) {
        this.pnr = pnr;
    }
    public ReturnPriceDetails getRp() {
        return rp;
    }
    public void setRp(ReturnPriceDetails rp) {
        this.rp = rp;
    }
    @Override
    public String toString() {
        return "Booking [id=" + id + ", pnr=" + pnr + ", rp=" + rp + "]";
    }
    
   
}
