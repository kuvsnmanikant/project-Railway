package com.capgemini.project.micreservice_train.controller;

import java.util.List;
import java.util.Optional;

import com.capgemini.project.micreservice_train.model.ListOfStationsAndCoaches;
import com.capgemini.project.micreservice_train.model.Train;
import com.capgemini.project.micreservice_train.services.Train1services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/train")
public class Train1Controller {

	// getting the instances of Train1services
	@Autowired
	private Train1services ts;

	// return all trains details
	@GetMapping("/alltrains")
	public List<Train> getAllTrains() {
		return ts.getAllTrains();
	}

	// getting the certain train details by id
	@GetMapping("/all/{id}")
	public Train getAllT(@PathVariable String id) {
		return ts.getAllT(id);
	}

	// find the train by train id and coatch type
	@GetMapping("/trainnotype/{id}/{coach_type}")
	public Train findByNoType(@PathVariable String id, @PathVariable String coach_type) {
		return ts.findByNoType(id, coach_type);
	}

	// it will return the train details by mongodb generated id
	@GetMapping("/train/{id}")
	public Optional<Train> getTrains(@PathVariable String id) {
		return ts.getTrains(id);
	}

	// it will add the new train details
	@PostMapping("/addtrain")
	public String addTrain(@RequestBody Train t) {
		return ts.addTrain(t);
	}

	// to delete the the train details by train id
	@DeleteMapping("/deletetrain/{id}")
	public String deleteTrain(@PathVariable String id) {
		return ts.deleteTrain(id);
	}

	// to update the train details by train id
	@PutMapping("/updateTrain/{s}")
	public String updateTrain(@RequestBody Train t, @PathVariable String s) {
		return ts.updateTrain(t, s);

	}

	// it will the list station the train will pass and number of coaches in the train
	@GetMapping("/listofstationsandcoaches/{trainno}/{coachtype}")
	public ListOfStationsAndCoaches listOfStationsAndCoaches(@PathVariable String trainno, @PathVariable String coachtype){
		return ts.listOfStationsAndCoaches(trainno, coachtype);
	}
}
