package com.capgemini.project.microservice_booking.models;
public class Price {
    private Ac ac;
    private Sl sl;
    public Price() {
    }
    public Price(Ac ac, Sl sl) {
        this.ac = ac;
        this.sl = sl;
    }
    public Ac getAc() {
        return ac;
    }
    public void setAc(Ac ac) {
        this.ac = ac;
    }
    public Sl getSl() {
        return sl;
    }
    public void setSl(Sl sl) {
        this.sl = sl;
    }
    @Override
    public String toString() {
        return "Price [ac=" + ac + ", sl=" + sl + "]";
    }
    
}
