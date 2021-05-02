package com.capgemini.project.micreservice_train.model;

public class Noseat {
	
	private Ac ac;
	private Sl sl;

	public Noseat(Ac ac, Sl sl) {
		super();
		this.ac = ac;
		this.sl = sl;
	}
	public Noseat(Sl sl) {
		super();
		this.sl = sl;
	}
	public Noseat(Ac ac) {
		super();
		this.ac = ac;
	}
	public Noseat() {
		super();
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
        return "Noseat [ac=" + ac + ", sl=" + sl + "]";
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
		Noseat other = (Noseat) obj;
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

