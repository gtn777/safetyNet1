package com.safetynet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.safetynet.api.model.FireStation;

@Repository
public interface FireStationRepository extends JpaRepository<FireStation, Long> {

	@Modifying
	@Query("update FireStation set station = ?2 where address = ?1 ")
	public void updateFireStationByAddress(String address, String station);

	
	@Modifying
	public void deleteAllByAddressOrStation(String address, String station);

}
