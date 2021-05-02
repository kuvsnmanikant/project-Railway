package com.capgemini.project.microservice_booking.models;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection="Ticket")
public class Ticket {
    @Id
    private String id;
    private String train_type;
    private Price price;
    public Ticket() {
    }
    public Ticket(String id, String train_type, Price price) {
        this.id = id;
        this.train_type = train_type;
        this.price = price;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTrain_type() {
        return train_type;
    }
    public void setTrain_type(String train_type) {
        this.train_type = train_type;
    }
    public Price getPrice() {
        return price;
    }
    public void setPrice(Price price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Ticket [id=" + id + ", price=" + price + ", train_type=" + train_type + "]";
    }
    
}