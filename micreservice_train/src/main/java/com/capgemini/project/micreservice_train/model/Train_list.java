package com.capgemini.project.micreservice_train.model;

public class Train_list {

    private String train_id;
    private String train_day;
    private String train_arivel;
    private String train_departure;

    public Train_list() {
    }

    public Train_list(String train_id, String train_day, String train_arivel, String train_departure) {
        this.train_id = train_id;
        this.train_day = train_day;
        this.train_arivel = train_arivel;
        this.train_departure = train_departure;
    }

    public String getTrain_id() {
        return train_id;
    }

    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }

    public String getTrain_day() {
        return train_day;
    }

    public void setTrain_day(String train_day) {
        this.train_day = train_day;
    }

    public String getTrain_arivel() {
        return train_arivel;
    }

    public void setTrain_arivel(String train_arivel) {
        this.train_arivel = train_arivel;
    }

    public String getTrain_departure() {
        return train_departure;
    }

    public void setTrain_departure(String train_departure) {
        this.train_departure = train_departure;
    }

    @Override
    public String toString() {
        return "Train_list [train_arivel=" + train_arivel + ", train_day=" + train_day + ", train_departure="
                + train_departure + ", train_id=" + train_id + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((train_arivel == null) ? 0 : train_arivel.hashCode());
        result = prime * result + ((train_day == null) ? 0 : train_day.hashCode());
        result = prime * result + ((train_departure == null) ? 0 : train_departure.hashCode());
        result = prime * result + ((train_id == null) ? 0 : train_id.hashCode());
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
        Train_list other = (Train_list) obj;
        if (train_arivel == null) {
            if (other.train_arivel != null)
                return false;
        } else if (!train_arivel.equals(other.train_arivel))
            return false;
        if (train_day == null) {
            if (other.train_day != null)
                return false;
        } else if (!train_day.equals(other.train_day))
            return false;
        if (train_departure == null) {
            if (other.train_departure != null)
                return false;
        } else if (!train_departure.equals(other.train_departure))
            return false;
        if (train_id == null) {
            if (other.train_id != null)
                return false;
        } else if (!train_id.equals(other.train_id))
            return false;
        return true;
    }

}
