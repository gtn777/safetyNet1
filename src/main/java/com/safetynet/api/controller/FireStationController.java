package com.safetynet.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.api.model.FireStation;
import com.safetynet.api.service.FireStationService;

@RestController
public class FireStationController {
	
	@Autowired
	private FireStationService fireStationService;
	
	@PostMapping("/firestation")
	public FireStation createFireStation(@RequestBody FireStation fireStation) {
		return fireStationService.createFireStation(fireStation);
	}
	
	@GetMapping("/firestation")
	public Iterable<FireStation> getAllFireStation(){
		return fireStationService.getAllFireStation();
	}
	
	@PutMapping("/firestation")
	public FireStation updateFireStation(@RequestBody FireStation fireStation) {
		return fireStationService.updateFireStation(fireStation);
		}
	
	@DeleteMapping("/firestation")
	public void deleteFireStation(@RequestBody FireStation fireStation) {
		fireStationService.deleteFireStation(fireStation);
	}
}
