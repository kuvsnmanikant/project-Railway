package com.capgemini.project.microservice_booking.models;

public class PassengerPrice {
    private String name;
    private double price;
    private double food;
    private double discount;
    private double amount;
    public PassengerPrice() {
    }
    public PassengerPrice(String name, double price, double food, double discount, double amount) {
        this.name = name;
        this.price = price;
        this.food = food;
        this.discount = discount;
        this.amount = amount;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getFood() {
        return food;
    }
    public void setFood(double food) {
        this.food = food;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "PassengerPrice [amount=" + amount + ", discount=" + discount + ", food=" + food + ", name=" + name
                + ", price=" + price + "]";
    }
   
   
}
