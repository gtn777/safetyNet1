package com.safetynet.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.safetynet.api.model.FireStation;

@Repository	
public interface FireStationRepository extends CrudRepository<FireStation, Long> {

	public FireStation deleteByAddress(String address);

	List<FireStation> findByAddress(String address);

	@Query("UPDATE firestations SET station=:station WHERE address=:address ")
	public FireStation updateFireStation(@Param("address") String address,@Param("station") String station);

}
