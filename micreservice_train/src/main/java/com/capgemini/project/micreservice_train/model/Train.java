package com.capgemini.project.micreservice_train.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Train")
public class Train {

    @Id
    private String id;
    @Indexed
    private String train_id;
    private String train_fistday;
    private String train_lastday;
    private String arrival_time;
    private String departure_time;
    private List<String> stations;
    private Details details;

    public Train() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrain_id() {
        return train_id;
    }

    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }

    public String getTrain_fistday() {
        return train_fistday;
    }

    public void setTrain_fistday(String train_fistday) {
        this.train_fistday = train_fistday;
    }

    public String getTrain_lastday() {
        return train_lastday;
    }

    public void setTrain_lastday(String train_lastday) {
        this.train_lastday = train_lastday;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public Train(String id, String train_id, String train_fistday, String train_lastday, String arrival_time,
            String departure_time, List<String> stations, Details details) {
        this.id = id;
        this.train_id = train_id;
        this.train_fistday = train_fistday;
        this.train_lastday = train_lastday;
        this.arrival_time = arrival_time;
        this.departure_time = departure_time;
        this.stations = stations;
        this.details = details;
    }

    @Override
    public String toString() {
        return "Train [arrival_time=" + arrival_time + ", departure_time=" + departure_time + ", details=" + details
                + ", id=" + id + ", stations=" + stations + ", train_fistday=" + train_fistday + ", train_id="
                + train_id + ", train_lastday=" + train_lastday + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((arrival_time == null) ? 0 : arrival_time.hashCode());
        result = prime * result + ((departure_time == null) ? 0 : departure_time.hashCode());
        result = prime * result + ((details == null) ? 0 : details.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((stations == null) ? 0 : stations.hashCode());
        result = prime * result + ((train_fistday == null) ? 0 : train_fistday.hashCode());
        result = prime * result + ((train_id == null) ? 0 : train_id.hashCode());
        result = prime * result + ((train_lastday == null) ? 0 : train_lastday.hashCode());
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
        Train other = (Train) obj;
        if (arrival_time == null) {
            if (other.arrival_time != null)
                return false;
        } else if (!arrival_time.equals(other.arrival_time))
            return false;
        if (departure_time == null) {
            if (other.departure_time != null)
                return false;
        } else if (!departure_time.equals(other.departure_time))
            return false;
        if (details == null) {
            if (other.details != null)
                return false;
        } else if (!details.equals(other.details))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (stations == null) {
            if (other.stations != null)
                return false;
        } else if (!stations.equals(other.stations))
            return false;
        if (train_fistday == null) {
            if (other.train_fistday != null)
                return false;
        } else if (!train_fistday.equals(other.train_fistday))
            return false;
        if (train_id == null) {
            if (other.train_id != null)
                return false;
        } else if (!train_id.equals(other.train_id))
            return false;
        if (train_lastday == null) {
            if (other.train_lastday != null)
                return false;
        } else if (!train_lastday.equals(other.train_lastday))
            return false;
        return true;
    }

}
