package com.safetynet.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.api.model.FireStation;
import com.safetynet.api.repository.FireStationRepository;

import lombok.Data;

@Data
@Service
public class FireStationService {

	@Autowired
	private FireStationRepository fireStationRepository;
	
	public FireStation createFireStation(FireStation fireStation) {
		return fireStationRepository.save(fireStation);
	}

	public Iterable<FireStation> getAllFireStation() {
		return fireStationRepository.findAll();
	}

	@Transactional
	public void updateFireStation(FireStation fireStation) {
		fireStationRepository.updateFireStationByAddress(fireStation.getAddress(), fireStation.getStation());
	}

	@Transactional
	public void deleteMapping(String mappingToDelete) {
		fireStationRepository.deleteAllByAddressOrStation(mappingToDelete, mappingToDelete);
}

	public void saveAllFireStations(List<FireStation> fireStations) {
		fireStationRepository.saveAll(fireStations);
	}
}
