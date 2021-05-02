package com.capgemini.project.microservice_ticket.models;
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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((train_type == null) ? 0 : train_type.hashCode());
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
        Ticket other = (Ticket) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (train_type == null) {
            if (other.train_type != null)
                return false;
        } else if (!train_type.equals(other.train_type))
            return false;
        return true;
    }
    
    
}