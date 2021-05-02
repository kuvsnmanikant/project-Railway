package com.capgemini.project.micreservice_train.controller;

import java.util.ArrayList;
import java.util.List;
import com.capgemini.project.micreservice_train.model.AddStation;
import com.capgemini.project.micreservice_train.model.AddTrain;
import com.capgemini.project.micreservice_train.model.ConvertSearchDetails;
import com.capgemini.project.micreservice_train.model.SearchDetails;
import com.capgemini.project.micreservice_train.model.Station;
import com.capgemini.project.micreservice_train.model.Stationno;
import com.capgemini.project.micreservice_train.model.TrainNo;
import com.capgemini.project.micreservice_train.model.TrainSearch;
import com.capgemini.project.micreservice_train.model.TrainTimeTable;
import com.capgemini.project.micreservice_train.services.Search1Service;
import com.capgemini.project.micreservice_train.services.Station1services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/search")
public class SearchTrains {
	// here we are creating the instance for SearchService class
	@Autowired
	private Search1Service ss;

	// we are creatingthe instance of Station1services
	@Autowired
	private Station1services sta;


	// this is the methid which will give serch train details
	@PostMapping("/trains")
	public ConvertSearchDetails ge(@RequestBody TrainSearch tr) {
		if(ss.ge(tr)==null){
			return new ConvertSearchDetails();
		}else {
			ConvertSearchDetails c= new ConvertSearchDetails();
			c.setS(ss.ge(tr));
			return c;
		}
		
	}

	// we are returning the train details on the base of staion1, station2, date, general
	@PostMapping("/train")
	public List<SearchDetails> gee(@RequestBody TrainSearch tr) {
		if(ss.ge(tr)==null){
			List<SearchDetails> v= new ArrayList<>();
			return v;
		}else {
			
			return ss.ge(tr);
		}
		
	}

	// this will return the train starting date
	@GetMapping("/trainstartindate/{id}/{date}/{coach")
	public List<String> getTrainStartingDate(@PathVariable String id,@PathVariable String date,@PathVariable String coach) {
		return ss.getTrainStartingDate(id,date,coach);
	}

	// it will fetch the data from the database and return the list of Stationno containing the properties of station number and name
	@GetMapping("/stations")
	public List<Stationno> getstationlist(){
		return ss.getstationlist();
	}

	// it will fetch the data from the database and return the list of TrainNo containing the properties of train number and name
	@GetMapping("/gettrainlist")
	public List<TrainNo> getTrainlist(){
		return ss.getTrainlist();
	}

	// it will return the station time table
	@GetMapping("/stationtimetable/{id}")
	public  Station getStation(@PathVariable String id){
		return sta.getStation(id);
	}

	// it will return the trian time table
	@GetMapping("/traintimetable/{id}")
	public  TrainTimeTable getTrainTimeTable(@PathVariable String id){
		TrainTimeTable tt= ss.getTrainTimeTable(id);
		System.out.println(tt);
		return tt;
	}
	
	// it will the new tarain details and update the station data base
	@PostMapping("/addtrain")
	public String addTrain(@RequestBody AddTrain at){
		System.out.println(at);
		return ss.addTrain(at);
	}

	// it will add new station and update the train data base
	@PostMapping("/addstation")
	public String addStation(@RequestBody AddStation s){
		return ss.addStation(s);
	}

	//  delete the train details and update the  station collection
	@DeleteMapping("/deletetrain/{id}")
	public String deleteTrain(@PathVariable String id){
		return ss.deleteTrain(id);
	}

	// it will delte the staion and update the train collection
	@DeleteMapping("/deletestation/{id}")
	public String deleteStation(@PathVariable String id){
		return ss.deleteStation(id);
	}

	// it will update the existing station details in the station collection
	@PutMapping("/updatestation")
	public String updateStation(@RequestBody AddStation t) {
		return ss.updateStation(t);
	}

}
