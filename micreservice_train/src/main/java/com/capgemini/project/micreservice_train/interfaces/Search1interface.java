package com.capgemini.project.micreservice_train.interfaces;

import java.util.List;
import com.capgemini.project.micreservice_train.model.SearchDetails;
import com.capgemini.project.micreservice_train.model.TrainSearch;

public interface Search1interface {
    public List<String> getTrainStartingDate(String i, String d,String coach);
    public List<SearchDetails> ge(TrainSearch tr);
}
