package com.capgemini.project.micreservice_train.model;

import java.util.List;
import org.springframework.data.mongodb.core.index.Indexed;

public class Details {

	@Indexed
	private String train_name;
	private String train_type;
	private String coach_type;
	private List<Integer> distance;
	private Noseat seat;

    @Override
    public String toString() {
        return "Details [coach_type=" + coach_type + ", distance=" + distance + ", seat=" + seat + ", train_name="
                + train_name + ", train_type=" + train_type + "]";
    }
    public String getTrain_name() {
        return train_name;
    }
    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }
    public String getTrain_type() {
        return train_type;
    }
    public void setTrain_type(String train_type) {
        this.train_type = train_type;
    }
    public String getCoach_type() {
        return coach_type;
    }
    public void setCoach_type(String coach_type) {
        this.coach_type = coach_type;
    }
    public List<Integer> getDistance() {
        return distance;
    }
    public void setDistance(List<Integer> distance) {
        this.distance = distance;
    }
    public Noseat getSeat() {
        return seat;
    }
    public void setSeat(Noseat seat) {
        this.seat = seat;
    }
    public Details(String train_name, String train_type, String coach_type, List<Integer> distance, Noseat seat) {
        this.train_name = train_name;
        this.train_type = train_type;
        this.coach_type = coach_type;
        this.distance = distance;
        this.seat = seat;
    }
    public Details() {
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((coach_type == null) ? 0 : coach_type.hashCode());
        result = prime * result + ((distance == null) ? 0 : distance.hashCode());
        result = prime * result + ((seat == null) ? 0 : seat.hashCode());
        result = prime * result + ((train_name == null) ? 0 : train_name.hashCode());
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
        Details other = (Details) obj;
        if (coach_type == null) {
            if (other.coach_type != null)
                return false;
        } else if (!coach_type.equals(other.coach_type))
            return false;
        if (distance == null) {
            if (other.distance != null)
                return false;
        } else if (!distance.equals(other.distance))
            return false;
        if (seat == null) {
            if (other.seat != null)
                return false;
        } else if (!seat.equals(other.seat))
            return false;
        if (train_name == null) {
            if (other.train_name != null)
                return false;
        } else if (!train_name.equals(other.train_name))
            return false;
        if (train_type == null) {
            if (other.train_type != null)
                return false;
        } else if (!train_type.equals(other.train_type))
            return false;
        return true;
    }
	
	
}
