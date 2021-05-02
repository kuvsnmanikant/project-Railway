package com.capgemini.project.micreservice_train.model;

public class ErrorhandlerObject {
    private String msg;

    public ErrorhandlerObject() {
    }

    public ErrorhandlerObject(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ErrorhandlerObject [msg=" + msg + "]";
    }
    
}
