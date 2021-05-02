package com.capgemini.project.microservice_booking.models;

public class Sl {
    private double distance;
    private Food food;
    private double insurance;
    public Sl() {
    }
    public Sl(double d, Food food, double e) {
        this.distance = d;
        this.food = food;
        this.insurance = e;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public Food getFood() {
        return food;
    }
    public void setFood(Food food) {
        this.food = food;
    }
    public double getInsurance() {
        return insurance;
    }
    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }
    @Override
    public String toString() {
        return "Sl [distance=" + distance + ", food=" + food + ", insurance=" + insurance + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(distance);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((food == null) ? 0 : food.hashCode());
        temp = Double.doubleToLongBits(insurance);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Sl other = (Sl) obj;
        if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
            return false;
        if (food == null) {
            if (other.food != null)
                return false;
        } else if (!food.equals(other.food))
            return false;
        if (Double.doubleToLongBits(insurance) != Double.doubleToLongBits(other.insurance))
            return false;
        return true;
    }
    
}
