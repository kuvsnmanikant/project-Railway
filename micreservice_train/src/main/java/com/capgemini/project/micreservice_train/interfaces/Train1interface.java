package com.capgemini.project.micreservice_train.interfaces;

import java.util.List;
import java.util.Optional;
import com.capgemini.project.micreservice_train.model.Train;

// this interface will be implemented on train service
public interface Train1interface {
    public List<Train> getAllTrains();
    public Optional<Train> getTrains(String id);
    public String addTrain(Train t);
    public String deleteTrain(String id);
    public String updateTrain(Train t, String s);
    public Train getAllT(String id);
    public Train findByNoType(String id, String coach_type);
}
