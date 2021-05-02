package com.capgemini.project.micreservice_train.controller;

import java.util.List;
import com.capgemini.project.micreservice_train.model.Station;
import com.capgemini.project.micreservice_train.services.Station1services;
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
@RequestMapping("/station")
public class Station1Controller {

	// creating the instances to the Station1services
	@Autowired
	private Station1services ts;

	// returning all the station data in the database
	@GetMapping("/allstations")
	public List<Station> getAllStations() {
		return ts.getAllStation();
	}

	// returning the certain station details by staion name
	@GetMapping("/allstations/{name}")
	public Station getAllS(@PathVariable String name) {
		return ts.getAllS(name);
	}

	// return the train details by checking the staion id and the day of the train
	@GetMapping("/findbyday/{station_id}/{day}")
	public Station findByDay(@PathVariable String station_id, @PathVariable String day) {
		return ts.findByDay(station_id, day);
	}

	// return the certain station details by station id
	@GetMapping("/stationid/{id}")
	public Station getStation(@PathVariable String id) {
		return ts.getStation(id);
	}

	// add new station details
	@PostMapping("/addstation")
	public String addStation(@RequestBody Station t) {
		return ts.addStation(t);
	}

	// deleting the station
	@DeleteMapping("/deletestation/{id}")
	public String deleteStation(@PathVariable String id) {
		return ts.deleteStation(id);
	}

	// updating the existing staion data
	@PutMapping("/updatestation/{s}")
	public String updateStation(@RequestBody Station t, @PathVariable String s) {
		return ts.updateStation(t, s);
	}
}
