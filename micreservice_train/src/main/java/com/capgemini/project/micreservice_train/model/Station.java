package com.capgemini.project.micreservice_train.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Station")
public class Station {
    @Id
    private String id;
    private String station_id;
    @Indexed
    private String station_name;
    @Field("station_list")
    private List<Train_list> station_list;
    
    public Station() {
    }
    public Station(String id, String station_id, String station_name, List<Train_list> station_list) {
        this.id = id;
        this.station_id = station_id;
        this.station_name = station_name;
        this.station_list = station_list;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getStation_id() {
        return station_id;
    }
    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }
    public String getStation_name() {
        return station_name;
    }
    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }
    public List<Train_list> getStation_list() {
        return station_list;
    }
    public void setStation_list(List<Train_list> station_list) {
        this.station_list = station_list;
    }
    @Override
    public String toString() {
        return "Station [id=" + id + ", station_id=" + station_id + ", station_list=" + station_list + ", station_name="
                + station_name + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((station_id == null) ? 0 : station_id.hashCode());
        result = prime * result + ((station_list == null) ? 0 : station_list.hashCode());
        result = prime * result + ((station_name == null) ? 0 : station_name.hashCode());
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
        Station other = (Station) obj;
        if (station_id == null) {
            if (other.station_id != null)
                return false;
        } else if (!station_id.equals(other.station_id))
            return false;
        if (station_list == null) {
            if (other.station_list != null)
                return false;
        } else if (!station_list.equals(other.station_list))
            return false;
        if (station_name == null) {
            if (other.station_name != null)
                return false;
        } else if (!station_name.equals(other.station_name))
            return false;
        return true;
    }
   
}
