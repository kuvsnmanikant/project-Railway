package com.capgemini.project.microservice_ticket.models;

public class Price {
    private Ac ac;
    private Sl sl;
    public Price() {
    }
    public Price(Ac ac, Sl sl) {
        this.ac = ac;
        this.sl = sl;
    }
    public Ac getAc() {
        return ac;
    }
    public void setAc(Ac ac) {
        this.ac = ac;
    }
    public Sl getSl() {
        return sl;
    }
    public void setSl(Sl sl) {
        this.sl = sl;
    }
    @Override
    public String toString() {
        return "Price [ac=" + ac + ", sl=" + sl + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ac == null) ? 0 : ac.hashCode());
        result = prime * result + ((sl == null) ? 0 : sl.hashCode());
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
        Price other = (Price) obj;
        if (ac == null) {
            if (other.ac != null)
                return false;
        } else if (!ac.equals(other.ac))
            return false;
        if (sl == null) {
            if (other.sl != null)
                return false;
        } else if (!sl.equals(other.sl))
            return false;
        return true;
    }
    
}
