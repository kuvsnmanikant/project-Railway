package com.capgemini.project.microservice_ticket.models;

public class Food {
    private int nv;
    private int veg;
    public Food() {
    }
    public Food(int nv, int veg) {
        this.nv = nv;
        this.veg = veg;
    }
    public int getNv() {
        return nv;
    }
    public void setNv(int nv) {
        this.nv = nv;
    }
    public int getVeg() {
        return veg;
    }
    public void setVeg(int veg) {
        this.veg = veg;
    }
    @Override
    public String toString() {
        return "Food [nv=" + nv + ", veg=" + veg + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + nv;
        result = prime * result + veg;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Food other = (Food) obj;
        if (nv != other.nv)
            return false;
        if (veg != other.veg)
            return false;
        return true;
    }
    
}
