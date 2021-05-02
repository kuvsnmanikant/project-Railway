package com.capgemini.project.micreservice_train.model;

import java.util.List;

public class ConvertSearchDetails {
    private List<SearchDetails> s;

    public ConvertSearchDetails() {
    }

    public ConvertSearchDetails(List<SearchDetails> s) {
        this.s = s;
    }

    public List<SearchDetails> getS() {
        return s;
    }

    public void setS(List<SearchDetails> s) {
        this.s = s;
    }
    
}
