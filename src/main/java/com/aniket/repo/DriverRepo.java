package com.aniket.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aniket.entity.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver, String>{

	List<Driver> findAllByStatus(String status);

	List<Driver> findAllByCityAndStatusAndRideStatus(String city, String status, String rideStatus);
	
	List<Driver> findAllByCity(String city); 
	
	List<Driver> findAllByCityAndRideStatus(String city, String RideStatus);

	List<Driver> findAllByStatusAndRideStatus(String status, String rideStatus); 
}
