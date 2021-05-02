package com.capgemini.project.microservice_booking.models;

public class Total_Seats {
    private int ac_no;
    private int sl_no;
    public Total_Seats() {
    }
    public Total_Seats(int ac_no, int sl_no) {
        this.ac_no = ac_no;
        this.sl_no = sl_no;
    }
    public int getAc_no() {
        return ac_no;
    }
    public void setAc_no(int ac_no) {
        this.ac_no = ac_no;
    }
    public int getSl_no() {
        return sl_no;
    }
    public void setSl_no(int sl_no) {
        this.sl_no = sl_no;
    }
    @Override
    public String toString() {
        return "Total_Seats [ac_no=" + ac_no + ", sl_no=" + sl_no + "]";
    }
}
