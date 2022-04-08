package com.safetynet.api.service;

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

	public Iterable<FireStation> getAllFireStation() {
		return fireStationRepository.findAll();
	}

	public FireStation createFireStation(FireStation fireStation) {
		return fireStationRepository.save(fireStation);
	}

	@Transactional
	public void updateFireStation(FireStation fireStation) {
		fireStationRepository.updateFireStationByAddress(fireStation.getAddress(), fireStation.getStation());
	}

	@Transactional
	public void deleteMapping(String mappingToDelete) {
		fireStationRepository.deleteAllByAddressOrStation(mappingToDelete, mappingToDelete);

	}

}
