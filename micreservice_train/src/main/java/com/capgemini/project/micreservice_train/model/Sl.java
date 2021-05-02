package com.capgemini.project.micreservice_train.model;

import java.util.List;

public class Sl {
    
	private List<Integer> coach;

	public Sl(List<Integer> coach) {
		super();
		this.coach = coach;
	}

	public Sl() {
		super();
	}

    public List<Integer> getCoach() {
        return coach;
    }

    public void setCoach(List<Integer> coach) {
        this.coach = coach;
    }

    @Override
    public String toString() {
        return "Sl [coach=" + coach + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((coach == null) ? 0 : coach.hashCode());
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
        if (coach == null) {
            if (other.coach != null)
                return false;
        } else if (!coach.equals(other.coach))
            return false;
        return true;
    }
	
}

