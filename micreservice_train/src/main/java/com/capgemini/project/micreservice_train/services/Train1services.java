package com.capgemini.project.micreservice_train.services;

import java.util.List;
import java.util.Optional;
import com.capgemini.project.micreservice_train.database.Traindatabase;
import com.capgemini.project.micreservice_train.exceptionhandlings.Notfoundexception;
import com.capgemini.project.micreservice_train.interfaces.Train1interface;
import com.capgemini.project.micreservice_train.model.ListOfStationsAndCoaches;
import com.capgemini.project.micreservice_train.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Train1services implements Train1interface{

	// this will create the instance of Traindatabase repository
    @Autowired
    private Traindatabase tdb;

	// this will return all the trains in the database
    public List<Train> getAllTrains(){
        return tdb.findAll();
    }

	// this will return the train details by id
	@Override
	public Train getAllT(String id){
   return tdb.findByName(id);
    }

	// this will return the train details by checking the train id and coach type
	@Override
	public Train findByNoType(String id, String coach_type){
		return tdb.findByNoType(id, coach_type);
	}

	// this will return the train details by mongodb id
    public Optional<Train> getTrains(String id){
        Optional<Train> a = tdb.findById(id);
		if(!a.isPresent()){
			try {
				throw new Notfoundexception("AddOn with the name "+ id + "not exist");
			} catch (Notfoundexception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		return a;
    }

	// this will add the trian details 
    public String addTrain(Train t){
		Train a = tdb.findByName(t.getTrain_id());
        if (a != null) {
            try {
				throw new Notfoundexception(t.getTrain_id() + " already exist");
			} catch (Notfoundexception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		tdb.save(t);
		return "Success";
	}

	// this will delete the train details by train id
    public String deleteTrain(String id){
        Train a = tdb.findByName(id);
		if(a==null){
			try {
				throw new Notfoundexception("AddOn with the name "+ id + "not exist");
			} catch (Notfoundexception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		tdb.deleteByName(id);
		return "deleted";
	}

	// this will update the train details
    public String updateTrain(Train t, String s){
        Train saved = tdb.findByName(s);
		if(saved==null){
			try {
				throw new Notfoundexception("AddOn with the id "+ s + "not exist");
			} catch (Notfoundexception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		tdb.deleteByName(s);	
		tdb.save(t);
		return "success";
    }

	public ListOfStationsAndCoaches listOfStationsAndCoaches(String trainno, String coachtype){
		Train t= tdb.findByName(trainno);
		ListOfStationsAndCoaches losac= new ListOfStationsAndCoaches();
		losac.setStations(t.getStations());
		if(coachtype.equalsIgnoreCase("ac")){
			losac.setCoaches(t.getDetails().getSeat().getAc().getCoach());
		}
		else{
			losac.setCoaches(t.getDetails().getSeat().getSl().getCoach());
		}
		
		return losac;
	}

}
