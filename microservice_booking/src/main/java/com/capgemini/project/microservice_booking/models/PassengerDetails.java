package com.capgemini.project.microservice_booking.models;

public class PassengerDetails {
    private String passenger_name;
    private int age;
    private String gender;
    private String handicap;
    private String food_type;
    public PassengerDetails() {
    }
    public PassengerDetails(String passenger_name, int age, String gender, String handicap, String food_type) {
        this.passenger_name = passenger_name;
        this.age = age;
        this.gender = gender;
        this.handicap = handicap;
        this.food_type = food_type;
    }
    public String getPassenger_name() {
        return passenger_name;
    }
    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getHandicap() {
        return handicap;
    }
    public void setHandicap(String handicap) {
        this.handicap = handicap;
    }
    public String getFood_type() {
        return food_type;
    }
    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }
    @Override
    public String toString() {
        return "PassengerDetails [age=" + age + ", food_type=" + food_type + ", gender=" + gender + ", handicap="
                + handicap + ", passenger_name=" + passenger_name + "]";
    }
}
